package cn.coderss.jysy.controller;

import cn.coderss.jysy.reqmodel.JysyReqModel;
import cn.coderss.jysy.service.ReportService;
import cn.coderss.jysy.utility.DateUtil;
import cn.coderss.jysy.utility.UuidStr;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/16
 * Time: 下午12:22
 * Blog: http://www.coderss.cn
 */
@RequestMapping("/task")
@RestController
public class TaskController {
    @Autowired
    ReportService reportService;
    Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    ArrayBlockingQueue<JysyReqModel> queue = new ArrayBlockingQueue<JysyReqModel>(1);
    Runnable consumer = ()->{
        while (true){
            try {
                JysyReqModel taskModel = queue.take();
                logger.info(taskModel.toString());
                /**
                 * (String start_date,String end_date,
                 String region, String regionId,
                 String people, String sign_ways, String pay_ways)
                 */
                SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String nowTime = format.format(new Date());
                String code = UuidStr.getUuidStr();

                String insertCeleryTaskSql = "INSERT INTO `vmobel`.`celery_taskinfo`\n" +
                        "(`code`,\n" +
                        "`type`,\n" +
                        "`states`,\n" +
                        "`createtime`,\n" +
                        "`starttime`,\n" +
                        "`endtime`,\n" +
                        "`import_description`,\n" +
                        "`import_params`,\n" +
                        "`result_description`,\n" +
                        "`result_file`,\n" +
                        "`collegeid`,\n" +
                        "`enterpriseid`,\n" +
                        "`accountid`,\n" +
                        "`import_file`,\n" +
                        "`result_error_stack`,\n" +
                        "`result_states`,\n" +
                        "`domain`)\n" +
                        "VALUES\n" +
                        "('"+code+"', '143', '121', \n" +
                        "'"+nowTime+"', '"+nowTime+"', \n" +
                        "'"+nowTime+"', '', \n" +
                        "'', \n" +
                        "'', '', '"+taskModel.getCollegeid()+"', '"+taskModel.getEnterpriseid()+"', '"+taskModel.getAccountid()+"', \n" +
                        "'', '', '120', NULL);\n" +
                        "\n";
                jdbcTemplate.execute(insertCeleryTaskSql);
                String datePath = "downloads/"+nowTime;
                String uuid = UUID.randomUUID().toString();
                String dirs = datePath +"/"+uuid +"/";
                reportService.province(taskModel.getStart_date(), taskModel.getEnd_date(),
                        taskModel.getRegion(), taskModel.getRegionId(), taskModel.getPeople(),
                        taskModel.getSign_ways(), taskModel.getPay_ways(), dirs, nowTime);
                String zipFilePath = reportService.detail(taskModel.getStart_date(), taskModel.getEnd_date(),
                        taskModel.getRegion(), taskModel.getRegionId(), taskModel.getPeople(),
                        taskModel.getSign_ways(), taskModel.getPay_ways(), dirs, nowTime);

                String updateCeleryTaskSql = "UPDATE `vmobel`.`celery_taskinfo` " +
                        "SET `result_states`='119',`states`='119',result_file='"+zipFilePath+"' " +
                        "WHERE `code`='"+code+"';\n";
                jdbcTemplate.execute(updateCeleryTaskSql);


            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.info("consumer has exception InterruptedException");
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("consumer has exception Exception");
            }
        }
    };

    private ExecutorService pool = Executors.newFixedThreadPool(2);
    {
        pool.submit(consumer);
    }

    @RequestMapping("/states")
    @CrossOrigin(origins = "*")
    public HashMap<String,String> states(){
        HashMap<String,String> result = new HashMap<>();
        if(queue.size() > 0){
            result.put("states","-1");
            result.put("msg","有任务");
        }
        else {
            result.put("states","1");
            result.put("msg","无任务");
        }
        return result;
    }

    @RequestMapping("/create")
    @CrossOrigin(origins = "*")
    public HashMap<String,String> createTask(JysyReqModel model){
        HashMap<String,String> resultMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Class modelClass = model.getClass();
            Field[] fields = modelClass.getFields();
            for (Field field: fields){
                if(field.get(model) == null){
                    stringBuilder.append(field.getName());
                    stringBuilder.append(":不能为空;");
                }
                else if((field.getName().equals("start_date") || field.getName().equals("end_date")) &&
                !DateUtil.isParseDate(field.get(model).toString())){
                    stringBuilder.append(field.getName());
                    stringBuilder.append(":日期格式不正确;");
                }

            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(stringBuilder.length() > 0){
            resultMap.put("msg", stringBuilder.toString());
            resultMap.put("states", "-1");
        }

        boolean result = queue.offer(model);
        if(result){
            resultMap.put("msg", "任务创建成功");
            resultMap.put("states", "1");
        }
        else{
            resultMap.put("msg", "任务创建失败");
            resultMap.put("states", "-1");
        }
        return resultMap;
    }

}

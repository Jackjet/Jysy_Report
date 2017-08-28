package cn.coderss.jysy.controller;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/24
 * Time: 上午10:20
 * Blog: http://www.coderss.cn
 */

import cn.coderss.jysy.reqmodel.JysyReqModel;
import cn.coderss.jysy.service.ReportService;
import cn.coderss.jysy.utility.DateUtil;
import cn.coderss.jysy.utility.FileUtilitys;
import cn.coderss.jysy.utility.UuidStr;
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
import java.util.concurrent.*;


@RequestMapping({"/task"})
@RestController
public class TaskController {
    @Autowired
    ReportService reportService;
    Logger logger = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    @Qualifier("thirdJdbcTemplate")
    JdbcTemplate jdbcTemplate;
    boolean isReady = true;
    SynchronousQueue<JysyReqModel> queue = new SynchronousQueue<>();
    Runnable consumer = () -> {
        while(true) {
            JysyReqModel taskModel = null;
            try {
                taskModel = (JysyReqModel)this.queue.take();
                isReady = false;
            } catch (InterruptedException var13) {
                var13.printStackTrace();
            }

            this.logger.info(taskModel.toString());
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String nowTime = format.format(new Date());
            String code = taskModel.getCode();

            String updateCeleryTaskSqlx;
            try {
                String insertCeleryTaskSql = "INSERT INTO `vmobel`.`celery_taskinfo`\n(`code`,\n`type`,\n`states`,\n`createtime`,\n`starttime`,\n`endtime`,\n`import_description`,\n`import_params`,\n`result_description`,\n`result_file`,\n`collegeid`,\n`enterpriseid`,\n`accountid`,\n`import_file`,\n`result_error_stack`,\n`result_states`,\n`domain`)\nVALUES\n('" + code + "', '322', '121', \n" + "'" + nowTime + "', '" + nowTime + "', \n" + "'" + nowTime + "', \"" + taskModel.toString() + "\", \n" + "'', \n" + "'', '', '" + taskModel.getCollegeid() + "', '" + taskModel.getEnterpriseid() + "', '" + taskModel.getAccountid() + "', \n" + "'', '', '120', NULL);\n" + "\n";
                this.jdbcTemplate.execute(insertCeleryTaskSql);
                updateCeleryTaskSqlx = "report_down/" + nowTime;
                String uuid = UUID.randomUUID().toString();
                String dirs = updateCeleryTaskSqlx + "/" + uuid + "/";
                this.reportService.province(taskModel.getStart_date(), taskModel.getEnd_date(), taskModel.getRegion(), taskModel.getRegionId(), taskModel.getPeople(), taskModel.getSign_ways(), taskModel.getPay_ways(), dirs, nowTime);
                String zipFilePath = this.reportService.detail(taskModel.getStart_date(), taskModel.getEnd_date(), taskModel.getRegion(), taskModel.getRegionId(), taskModel.getPeople(), taskModel.getSign_ways(), taskModel.getPay_ways(), dirs, nowTime);
                StringBuilder resultFile = new StringBuilder();
                resultFile.append("download");
                resultFile.append(zipFilePath.substring(zipFilePath.indexOf("/"), zipFilePath.length()));
                System.out.println(resultFile);
                String updateCeleryTaskSql = "UPDATE `vmobel`.`celery_taskinfo` SET `result_states`='119',`states`='119',result_file='" + resultFile + "' " + "WHERE `code`='" + code + "';\n";
                this.jdbcTemplate.execute(updateCeleryTaskSql);
            } catch (Exception var12) {
                this.logger.info("stack:" + FileUtilitys.getStackMsg(var12));
                updateCeleryTaskSqlx = "update vmobel.celery_taskinfo\nset result_error_stack=\"" + FileUtilitys.getStackMsg(var12) + "\", result_states=118\n" + "where code=\"" + code + "\"";
                this.jdbcTemplate.execute(updateCeleryTaskSqlx);
            }
            isReady = true;
        }
    };
    private ExecutorService pool = Executors.newFixedThreadPool(2);

    public TaskController() {
        this.pool.submit(this.consumer);
    }

    @RequestMapping({"/states"})
    @CrossOrigin(
            origins = {"*"}
    )
    public HashMap<String, String> states() {
        HashMap<String, String> result = new HashMap();
        if(!isReady) {
            result.put("states", "-1");
            result.put("msg", "请稍后导出,上一任务进行中");
        } else {
            result.put("states", "1");
            result.put("msg", "无任务");
        }

        return result;
    }

    @RequestMapping({"/create"})
    @CrossOrigin(
            origins = {"*"}
    )
    public HashMap<String, String> createTask(JysyReqModel model) {
        HashMap<String, String> resultMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Class modelClass = model.getClass();
            Field[] fields = modelClass.getFields();
            Field[] var6 = fields;
            int var7 = fields.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Field field = var6[var8];
                if(field.get(model) == null && !field.getName().equals("code")) {
                    stringBuilder.append(field.getName());
                    stringBuilder.append(":不能为空;");
                } else if((field.getName().equals("start_date") || field.getName().equals("end_date")) && !DateUtil.isParseDate(field.get(model).toString())) {
                    stringBuilder.append(field.getName());
                    stringBuilder.append(":日期格式不正确;");
                }
            }
        } catch (IllegalAccessException var10) {
            var10.printStackTrace();
        }

        if(stringBuilder.length() > 0) {
            resultMap.put("msg", stringBuilder.toString());
            resultMap.put("states", "-1");
            return resultMap;
        }

        String uuid = UuidStr.getUuidStr();
        model.setCode(uuid);
        boolean result = this.queue.offer(model);
        if(result) {
            StringBuilder resultOut = new StringBuilder();
            resultOut.append("系统处理中，任务编号:");
            resultOut.append(uuid);
            resultOut.append("预计10分钟后可在任务管理查看处理结果");
            resultMap.put("msg", resultOut.toString());
            resultMap.put("states", "1");
        } else {
            resultMap.put("msg", "任务创建失败");
            resultMap.put("states", "-1");
        }

        return resultMap;
    }
}

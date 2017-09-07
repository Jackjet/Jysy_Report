package cn.coderss.jysy.controller;

import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;
import cn.coderss.jysy.service.StudyPlanService;
import cn.coderss.jysy.utility.FileUtilitys;
import cn.coderss.jysy.utility.UuidStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/28
 * Time: 下午1:15
 * Blog: http://www.coderss.cn
 */
@RestController
@RequestMapping("/study-plan-task")
@Transactional
public class StudyPlanDetailTaskController {
    Logger logger = LoggerFactory.getLogger(StudyPlanDetailTaskController.class);
    SynchronousQueue<StudyPlanDetailReqModel> queue = new SynchronousQueue<>();
    ExecutorService pool = Executors.newFixedThreadPool(1);


    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    boolean isReady = true;

    @Autowired
    StudyPlanService service;

    Runnable task = ()->{
        while (true){
            StudyPlanDetailReqModel model = null;
            try {
                model = queue.take();
                isReady = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
            String nowTime = format.format(new Date());
            String uuid = model.getUuidCode();
            StringBuilder fileName = new StringBuilder();
            fileName.append("report_down/").append(nowTime).append("/").append(nowTime).append(".xlsx");
            String dirs = "report_down/"+ nowTime;
            FileUtilitys.makeDir(dirs);
            try {
                String insertCeleryTaskSql = "INSERT INTO `vmobel`.`celery_taskinfo`\n(`code`,\n`type`,\n`states`,\n`createtime`,\n`starttime`,\n`endtime`,\n`import_description`,\n`import_params`,\n`result_description`,\n`result_file`,\n`collegeid`,\n`enterpriseid`,\n`accountid`,\n`import_file`,\n`result_error_stack`,\n`result_states`,\n`domain`)\nVALUES\n('" +
                        uuid + "', '323', '121', \n" + "'" + nowTime + "', '" + nowTime + "', \n" + "'" + nowTime + "', \"" + model.toString() + "\", \n" + "'', \n" + "'', '', '" + model.getCollegeid() + "', '" + model.getEnterpriseid() + "', '" + model.getAccountid() + "', \n" + "'', '', '120', NULL);\n" + "\n";
                this.primaryJdbcTemplate.execute(insertCeleryTaskSql);
                service.doExecl(model, fileName.toString());
                String updateCeleryTaskSql = "UPDATE `vmobel`.`celery_taskinfo` SET `result_states`='119',`states`='119',result_file='" + fileName.toString().replace(".xlsx", ".zip").replace("report_down", "download") + "' " + "WHERE `code`='" + uuid + "';\n";
                this.primaryJdbcTemplate.execute(updateCeleryTaskSql);
            } catch (Exception e) {
                e.printStackTrace();
                String updateCeleryTaskSqlx = "update vmobel.celery_taskinfo\nset result_error_stack=\"" + FileUtilitys.getStackMsg(e) + "\", result_states=118\n" + "where code=\"" + uuid + "\"";
                this.primaryJdbcTemplate.execute(updateCeleryTaskSqlx);
            }
        }
    };
    {
        pool.submit(task);
    }

    @RequestMapping("/create")
    @CrossOrigin(
            origins = {"*"}
    )
    public HashMap<String, String> create(StudyPlanDetailReqModel model){
        HashMap<String, String> resultMap = new HashMap();
        List<String> codeData = new ArrayList<String>(){{
            addAll(Arrays.asList("yanshi2017061901", "yanshi2017062001", "yanshi2017062002",
                    "yanshi2017062003", "yanshi2017062004", "yanshi2017062005",
                    "yanshi2017062006", "yanshi2017062007", "yanshi2017062008",
                    "yanshi2017062009", "yanshi2017062010", "yanshi2017062011"));
        }};
        ArrayList<String> codes = new ArrayList<String>(){{
            addAll(Arrays.asList(model.getCode().split(",")));
        }};
        if(!codeData.containsAll(codes)){
            codes.removeAll(codeData);
            resultMap.put("msg", "有误的学习计划编码:" + codes.toString());
            resultMap.put("states", "-1");
            return resultMap;
        }
        String uuid = UuidStr.getUuidStr();
        model.setUuidCode(uuid);
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

    @RequestMapping("/test")
    public String test(){
        String encoding = System.getProperty("sun.jnu.encoding");
        return encoding;
    }

}

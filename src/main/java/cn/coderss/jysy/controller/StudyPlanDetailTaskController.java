package cn.coderss.jysy.controller;

import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;
import cn.coderss.jysy.service.ReportStopService;
import cn.coderss.jysy.service.StudyPlanService;
import cn.coderss.jysy.utility.FileUtilitys;
import cn.coderss.jysy.utility.UuidStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
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
    ExecutorService pool = Executors.newSingleThreadExecutor();


    @Autowired
    @Qualifier("thirdJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    boolean isReady = true;

    @Autowired
    StudyPlanService service;

    @Autowired
    ReportStopService reportStopService;

    Runnable task = ()->{
        while (true){
            StudyPlanDetailReqModel model = null;
            try {
                model = queue.take();
                isReady = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //停止掉之前的服务
            reportStopService.stopReportService();

            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
            String nowTime = format.format(new Date());
            String uuid = model.getUuidCode();
            StringBuilder fileName = new StringBuilder();
            fileName.append("report_down/").append(nowTime).append("/")
                    .append("学习计划考核成绩");
            //判断是否有省份
            if(!model.getRegion().equals("全国")){
                fileName.append("-").append(model.getRegion()).append("-");
            }
            fileName.append(model.getStartDate()).append("_")
                    .append(model.getEndDate()).append(".xlsx");
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
            finally {
                isReady = true;
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
    public HashMap<String, String> create(@Valid StudyPlanDetailReqModel model, BindingResult resultBind) throws ParseException {
        HashMap<String, String> resultMap = new HashMap();
        //判断数据是否有问题
        if(resultBind.hasErrors()){
            List<ObjectError> errorList = resultBind.getAllErrors();
            for(ObjectError error : errorList){
                resultMap.put("msg", error.getDefaultMessage());
                resultMap.put("states", "-1");
                return resultMap;
            }
        }
        if(isTimeInterval(model.getStartDate(), model.getEndDate())){
            return doSetResultMap(null, "-1", "时间范围不可超过6个月");
        }
        if(model.getCode().split(",").length > 20){
            return doSetResultMap(null, "-1", "学习编码数据不能超过20个");
        }

        //编码校验
        List<String> codeData = this.primaryJdbcTemplate.query("select `lear`.`code`\n" +
                "from vmobel.vmb_dictionaryitem as `item`\n" +
                "inner join vmobel.vmb_learningactivity as `lear` on `lear`.`actType`=`item`.`itemid`\n" +
                "inner join (\n" +
                "select `ship`.`learningactivityid`\n" +
                "from vmobel.vmb_activityownership as `ship` \n" +
                "where `ship`.`collegeid`=94\n" +
                "union all\n" +
                "select `orgdis`.`learningactivityid`\n" +
                "from vmobel.vmb_activityorgdistrib as `orgdis`\n" +
                "where `orgdis`.`destcollegeid`=94\n" +
                ") as `data`\n" +
                "on `data`.`learningactivityid` = `lear`.`learningactivityid`\n" +
                "where `item`.`code`=\"studyplanactivity\";", (rs, num)->{
            return rs.getString("code");
        });


        ArrayList<String> codes = new ArrayList<String>(){{addAll(new LinkedHashSet<String>(Arrays.asList(model.getCode().split(","))));}};

        //重新放入model
        model.setCode(String.join(",", codes));
        if(!codeData.containsAll(codes)){
            codes.removeAll(codeData);
            return doSetResultMap(null, "-1", "有误的学习计划编码:" + codes.toString());
        }
        String uuid = UuidStr.getUuidStr();
        model.setUuidCode(uuid);
        if(this.queue.offer(model)) {
            StringBuilder resultOut = new StringBuilder();
            resultOut.append("系统处理中，任务编号:");
            resultOut.append(uuid);
            resultOut.append("预计10分钟后可在任务管理查看处理结果");
            return doSetResultMap(null, "1", resultOut.toString());
        } else {
            isReady = false;
            return doSetResultMap(null, "-1", "任务创建失败");
        }
    }

    @RequestMapping({"/states"})
    @CrossOrigin(
            origins = {"*"}
    )
    public HashMap<String, String> states() {
        if(isReady) {
            return doSetResultMap(null, "1", "无任务");
        } else {
            return doSetResultMap(null, "-1", "请稍后导出,上一任务进行中");
        }
    }

    @RequestMapping("/test")
    public String test(){
        String encoding = System.getProperty("sun.jnu.encoding");
        return encoding;
    }


    HashMap<String, String> doSetResultMap(HashMap<String,String> map, String states, String msg){
        if (map == null){
            map = new HashMap<String,String>();
        }
        map.put("states", states);
        map.put("msg", msg);
        return map;
    }

    public boolean isTimeInterval(String startDate, String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = dateFormat.parse(startDate);
        Date endTime = dateFormat.parse(endDate);
        long diff = endTime.getTime() - startTime.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        return days > 186? true:false;
    }

}

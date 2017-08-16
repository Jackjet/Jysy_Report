package cn.coderss.jysy.controller;

import cn.coderss.jysy.reqmodel.JysyReqModel;
import cn.coderss.jysy.service.ReportService;
import cn.coderss.jysy.utility.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                String datePath = "downloads/"+nowTime;
                String uuid = UUID.randomUUID().toString();
                String dirs = datePath +"/"+uuid +"/";
                reportService.province(taskModel.getStart_date(), taskModel.getEnd_date(),
                        taskModel.getRegion(), taskModel.getRegionId(), taskModel.getPeople(),
                        taskModel.getSign_ways(), taskModel.getPay_ways(), dirs, nowTime);
                reportService.detail(taskModel.getStart_date(), taskModel.getEnd_date(),
                        taskModel.getRegion(), taskModel.getRegionId(), taskModel.getPeople(),
                        taskModel.getSign_ways(), taskModel.getPay_ways(), dirs, nowTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private ExecutorService pool = Executors.newFixedThreadPool(2);
    {
        pool.submit(consumer);
    }

    @RequestMapping("/states")
    public String states(){
        return queue.size() > 0?"有任务":"无任务";
    }

    @RequestMapping("/create")
    public String createTask(JysyReqModel model){
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
            return stringBuilder.toString();
        }
        if(model.getEnd_date()==null){
            return "end_date 不能为空";
        }
        boolean result = queue.offer(model);
        return result?"任务创建成功":"任务创建失败";
    }

}

package cn.coderss.jysy.controller;

import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;
import cn.coderss.jysy.service.StudyPlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    StudyPlanService service;

    Runnable task = ()->{
        while (true){
            try {
                StudyPlanDetailReqModel model = queue.take();
                logger.info("getDataInTask");
                service.doExecl(model, "report_down");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };
    {
        pool.submit(task);
    }

    @RequestMapping("/create")
    public HashMap<String, String> create(StudyPlanDetailReqModel model){
        boolean result = queue.offer(model);
        return new HashMap<String,String>(){{
            put("msg",result? "ok":"not ok");
            put("states",result?"1":"-1");
        }};
    }

    @RequestMapping("/test")
    public String test(){
        String encoding = System.getProperty("sun.jnu.encoding");
        return encoding;
    }

}

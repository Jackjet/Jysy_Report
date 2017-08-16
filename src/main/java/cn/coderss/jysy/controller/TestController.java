package cn.coderss.jysy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/test")
@RestController
public class TestController {
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
    Runnable consumer = ()->{
        while (true){
            try {
                String task = queue.take();
                Thread.sleep(5000);
                System.out.println(task);
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

    @RequestMapping("/thread")
    public String threadTest(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        boolean result = queue.offer("一个任务,Time:" + simpleDateFormat.format(new Date()));
        return result?"任务创建成功":"任务创建失败";
    }
}

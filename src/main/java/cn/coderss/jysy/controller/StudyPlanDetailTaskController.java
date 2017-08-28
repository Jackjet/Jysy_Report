package cn.coderss.jysy.controller;

import com.mysql.jdbc.ResultSetRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    SynchronousQueue<String> queue = new SynchronousQueue<>();
    ExecutorService pool = Executors.newFixedThreadPool(1);
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;
    Runnable task = ()->{
        while (true){
            try {
                String str = queue.take();
                logger.info(str);
                String startDate = "2017-06-25 00:00:00";
                String endDate = "2017-08-01 00:00:00";
                String sql = "SELECT TT.`province` as `province`,TT.`city` as `city`,TT.`county` as `country`,TT.`org_custom_name` as `org_custom_name`,\n" +
                        "TT.`org_name_second` as `org_name_second`,TT.`org_name` as `org_name`,concat(\"'\",TT.`name`) as `name`,TT.`fullname` as `fullname`,\n" +
                        "TT.`sex` as `sex`,concat(\"'\",TT.`birthday` )as `birthday`,concat(\"'\",TT.`mail`) as `mail`"+
                        "FROM `vmb_account` as `account`\n" +
                        "INNER JOIN `vmb_member` as `member`\n" +
                        "on `account`.`accountId`  = `member`.`accountId` \n" +
                        "INNER JOIN `vmb_collegeorg`  as `colorg`\n" +
                        "on `colorg`.`orgId`  = `member`.`ordId` \n" +
                        "INNER JOIN `vmb_org`  as `org`\n" +
                        "on `org`.`orgId`  =`member`.`ordId` \n" +
                        "INNER JOIN `vmb_enterpriseaccount` as `entaccount` \n" +
                        "on `entaccount`.`accountid` = `account`.`accountid`\n" +
                        "WHERE `colorg`.`collegeId` =94\n" +
                        "and `entaccount`.`enterpriseid`=11\n" +
                        "AND `account`.`accountid` in (\n" +
                        "    SELECT DISTINCT(`account`.`accountId`)\n" +
                        "    FROM `vmb_collegeorg` as `colorg`\n" +
                        "    INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                        "    INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                        "    INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                        "    INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                        "    WHERE `entaccount`.`createtime`>= \""+startDate+"\"\n" +
                        "    AND `entaccount`.`createtime` <= \""+endDate+"\"\n" +
                        "    AND `colorg`.`collegeId` =94\n" +
                        "    AND `entaccount`.`states` <> 58        \n" +
                        "    AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                        "    AND `account`.`accountid` not in (\n" +
                        "        SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                        "        AND `order_states` =272 \n" +
                        "        AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                        "    )\n" +
                        "    union all\n" +
                        "    select `order`.`accountid`\n" +
                        "    from `vmb_order` as `order`\n" +
                        "    INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                        "    INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                        "    where `pay_time` > \""+startDate+"\"\n" +
                        "    and `pay_time` <= \""+endDate+"\"\n" +
                        "    and `pay_ways`  !=275 AND `order_states` =272\n" +
                        "    AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                        "    GROUP BY `order`.`accountid`\n" +
                        ")\n" +
                        "and `entaccount`.`createtime` <= \""+endDate+"\"\n" +
                        "GROUP BY `account`.`accountid`\n" +
                        "ORDER BY `account`.`createtime` DESC ";
                logger.info(sql);
                List<HashMap<String,String>> mapList = (List<HashMap<String, String>>) primaryJdbcTemplate.queryForMap(sql);
                mapList.stream().forEach(item->{
                    item.values().forEach(value->{
                        logger.info(value);
                    });
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };
    {
        pool.submit(task);
    }

    @RequestMapping("/create")
    public HashMap<String, String> create(String msg){
        boolean result = queue.offer(msg);
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


    @RequestMapping("/create-file")
    public String createFile(){
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<10; i++){
            list.add("测试文件"+i+".xlsx");
        }
        try {
            for (String fileName : list){
                FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
                fileOutputStream.write("测试".getBytes());
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "createFile";
    }
}

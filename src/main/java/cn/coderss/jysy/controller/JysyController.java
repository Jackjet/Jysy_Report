package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.service.ReportProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/17
 * Time: 上午10:29
 * Blog: http://www.coderss.cn
 */
@Controller
@RequestMapping("/jysy")
public class JysyController {
    @Autowired
    ReportDetailService service;

    @Autowired
    ReportProvinceService provinceService;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/detail")
    public String detail(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("Y-MM-d");
        String dateStr = dateFormat.format(new Date());
        String sql = "SELECT TT.`province` as `province`,TT.`city` as `city`,TT.`county` as `country`,TT.`org_custom_name` as `org_custom_name`,\n" +
                "TT.`org_name_second` as `org_name_second`,TT.`org_name` as `org_name`,concat(\"'\",TT.`name`) as `name`,TT.`fullname` as `fullname`,\n" +
                "TT.`sex` as `sex`,concat(\"'\",TT.`birthday` )as `birthday`,concat(\"'\",TT.`mail`) as `mail`,\n" +
                "TT.`position` as `position`,TT.`sign_ways` as `sign_ways`,concat(\"'\",TT.`createtime`) as `createtime`,TT.`order_states` as `order_states`,\n" +
                "TT.`pay_ways` as `pay_ways`,concat(\"'\",TT.`pay_time`) as `pay_time`,\n" +
                "TT.`org_custom_name` as `org_custom_name`,TT.`address` as `address`,\n" +
                "CASE WHEN TT.`periods` is null THEN 0 ELSE TT.`periods` END  as `periods`,\n" +
                "TT.`cer_states` as `cer_states`,concat(\"'\",TT.`cer_time`) as `cer_time`,\n" +
                "concat(\"'\",TT.`cer_code`) as `cer_code`,\n" +
                "concat(\"'\",TT.`mobile`) as `mobile`,\n" +
                "concat(\"'\",TT.`createuser`) as `createuser`\n" +
                "FROM (\n" +
                "    SELECT \n" +
                "        (SELECT `region_name`\n" +
                "        FROM `vmb_region` \n" +
                "        WHERE `regionid` = `org`.`provinceid` ) as `province`,\n" +
                "        (SELECT `region_name`\n" +
                "         FROM `vmb_region` \n" +
                "        WHERE `regionid` = `org`.`cityid` ) as `city`,\n" +
                "        (SELECT `region_name`\n" +
                "         FROM `vmb_region` \n" +
                "        WHERE `regionid` = `org`.`countyid` ) as `county`,\n" +
                "        `account`.`name` ,\n" +
                "        `account`.`fullname` ,\n" +
                "        CASE WHEN `account`.`sex` = 1 THEN \"男\"\n" +
                "        WHEN `account`.`sex` = 2 THEN \"女\"\n" +
                "        ELSE \"\" END  as `sex`,DATE_FORMAT(`account`.`birthday`,\"%Y-%m\") as `birthday` ,\n" +
                "        (\n" +
                "            SELECT `parent_org`.`name` FROM `vmb_org` as `sun_org`\n" +
                "            INNER JOIN `vmb_org` as `parent_org`\n" +
                "            on `parent_org`.`orgid` = `sun_org`.`parentorgid`\n" +
                "            WHERE `sun_org`.`orgid` = `member`.`org_second_id`\n" +
                "        ) as `org_name_second`,\n" +
                "        (\n" +
                "            SELECT `name` FROM `vmb_org` \n" +
                "            WHERE `orgid` = `member`.`org_second_id`\n" +
                "        ) as `org_name`,\n" +
                "        `member`.`org_custom_name`,\n" +
                "        `member`.`position`,(\n" +
                "            SELECT CASE WHEN `order`.`pay_ways`  = 275\n" +
                "            THEN \"免费账号\"\n" +
                "            WHEN `order`.`pay_ways`  = 276\n" +
                "            THEN \"团体支付\"\n" +
                "            WHEN `order`.`pay_ways`  = 277\n" +
                "            THEN \"线上支付\"\n" +
                "            WHEN `order`.`pay_ways` = 278\n" +
                "            THEN \"线下汇款\"\n" +
                "            END \n" +
                "            FROM `vmb_order` as `order`\n" +
                "            WHERE `order`.`accountId`  = `account`.`accountId` \n" +
                "            LIMIT 1\n" +
                "        ) as `pay_ways`,(\n" +
                "            SELECT CASE WHEN `order`.`pay_ways`  = 275\n" +
                "            THEN \"免费账号\"\n" +
                "            WHEN `order`.`pay_ways`  = 276\n" +
                "            THEN \"团体报名\"\n" +
                "            WHEN `order`.`pay_ways`  = 277 or `order`.`pay_ways` = 278\n" +
                "            THEN \"个人注册\"\n" +
                "            END \n" +
                "            FROM `vmb_order` as `order`\n" +
                "            WHERE `order`.`accountId`  = `account`.`accountId` \n" +
                "            LIMIT 1\n" +
                "        ) as `sign_ways`,`entaccount`.`createtime`  as `createtime`,\n" +
                "        (\n" +
                "            SELECT CASE WHEN COUNT(*)>0\n" +
                "            THEN \"已支付\"\n" +
                "            ELSE \"未支付\"\n" +
                "            END\n" +
                "            FROM `vmb_order`  as `order`\n" +
                "            WHERE `order`.`accountid`  = `account`.`accountId` \n" +
                "            AND `order`.`order_states` = 272\n" +
                "            and  `order`.`pay_time` >= \"2017-06-25 00:00:00\"\n" +
                "            AND `order`.`pay_time` <= \'"+dateStr+" 02:59:59\'\n" +
                "            LIMIT 1\n" +
                "        ) as `order_states`,\n" +
                "        (\n" +
                "            SELECT `pay_time`\n" +
                "            FROM `vmb_order`  as `order`\n" +
                "            WHERE `order`.`accountid`  = `account`.`accountId` \n" +
                "            AND `order`.`order_states` = 272 \n" +
                "            and  `order`.`pay_time` >= \"2017-06-25 00:00:00\"\n" +
                "            AND `order`.`pay_time` <= \'"+dateStr+" 02:59:59\'\n" +
                "            LIMIT 1\n" +
                "        ) as `pay_time`,\n" +
                "        (\n" +
                "            SELECT CASE WHEN COUNT(*)>0 THEN \"已获得\" ELSE \"未获得\" END \n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.starttime <= \'"+dateStr+" 02:59:59\'\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "            limit 1\n" +
                "        ) as `cer_states`,\n" +
                "        (\n" +
                "            SELECT MIN(`study`.`starttime`) as `time` \n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.starttime <= \'"+dateStr+" 02:59:59\'\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "        ) as `cer_time`,\n" +
                "        (\n" +
                "            SELECT `study`.`certificate_code`\n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "            AND `study`.starttime <= \'"+dateStr+" 02:59:59\'\n" +
                "            ORDER BY `study`.`starttime` \n" +
                "            limit 1\n" +
                "        ) as `cer_code`,\n" +
                "        (\n" +
                "        SELECT SUM(P.`periods`)\n" +
                "        FROM (\n" +
                "            SELECT `study`.`learningActivityId` ,`study`.`accountid` ,`lear`.`periods` \n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity` as `lear` on `lear`.`learningActivityId`  = `study`.`learningactivityid`  AND `study`.`collegeid` =94\n" +
                "            INNER JOIN `tempdata`.`jysy_learning_account` as `jysy` on `jysy`.`accountid`  = `study`.`accountid`  AND `jysy`.`learningactivityid`  = `study`.`learningactivityid` \n" +
                "            INNER JOIN `vmb_account` as `maccount` on `maccount`.`accountId`  = `study`.`accountid`\n" +
                "            WHERE `study`.sucessfuled=1 AND `study`.valid = 1 AND `study`.starttime <= \'"+dateStr+" 02:59:59\'\n" +
                "            GROUP BY `study`.`accountid`,`study`.`learningactivityid`) as `P`\n" +
                "        WHERE  `P`.accountid = `account`.`accountid`\n" +
                "        GROUP BY `P`.`accountid`\n" +
                "        ) as `periods`,\n" +
                "        (\n" +
                "            select `detail_address`\n" +
                "            from `vmb_address`\n" +
                "            where `accountid` = `account`.`accountid`\n" +
                "        ) as `address`,`account`.`mail`,`account`.`mobile`,`account`.`createuser`\n" +
                "    FROM `vmb_account` as `account`\n" +
                "    INNER JOIN `vmb_member` as `member`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_collegeorg`  as `colorg`\n" +
                "    on `colorg`.`orgId`  = `member`.`ordId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `org`.`orgId`  =`member`.`ordId` \n" +
                "    INNER JOIN `vmb_enterpriseaccount` as `entaccount` \n" +
                "    on `entaccount`.`accountid` = `account`.`accountid`\n" +
                "    WHERE `colorg`.`collegeId` =94\n" +
                "    and `entaccount`.`enterpriseid`=11\n" +
                "    AND `account`.`accountid` in (\n" +
                "        SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \"2017-06-25 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \'"+dateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        union all\n" +
                "        select `accountid`\n" +
                "        from `vmb_order`\n" +
                "        where `pay_time` > \"2017-06-25 00:00:00\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "    )\n" +
                "    and `entaccount`.`createtime` <= \'"+dateStr+" 02:59:59\'\n" +
                "    GROUP BY `account`.`accountid`\n" +
                "    ORDER BY `account`.`createtime` DESC \n" +
                ")TT\n" +
                "\n";
        List<LinkedHashMap<String,String>> data = this.jdbcTemplate.query(sql ,(rs, num)->{
            return new LinkedHashMap<String,String>(){{
                put("province", rs.getString("province"));
                put("city", rs.getString("city"));
                put("country", rs.getString("country"));
                put("org_custom_name",rs.getString("org_custom_name"));
                put("org_name_second", rs.getString("org_name_second"));
                put("org_name", rs.getString("org_name"));
                put("name", rs.getString("name"));
                put("fullname", rs.getString("fullname"));
                put("sex", rs.getString("sex"));
                put("birthday", rs.getString("birthday"));
                put("mail", rs.getString("mail"));
                put("position", rs.getString("position"));
                put("sign_ways", rs.getString("sign_ways"));
                put("createtime", rs.getString("createtime"));
                put("order_states", rs.getString("order_states"));
                put("pay_ways", rs.getString("pay_ways"));
                put("pay_time", rs.getString("pay_time"));
                put("org_custom_name", rs.getString("org_custom_name"));
                put("address", rs.getString("address"));
                put("periods", rs.getString("periods"));
                put("cer_states", rs.getString("cer_states"));
                put("cer_time", rs.getString("cer_time"));
                put("cer_code", rs.getString("cer_code"));
            }};
        });
        try {
            return service.readOnlineExcel(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @RequestMapping("/province")
    public String province(){
        String getAllSql = "SELECT `province_name` as `province_name`,`city_name` as `city_name`,`county_name` as `county_name`,\n" +
                "CASE WHEN `city_id` = 0 AND `county_id` = 0\n" +
                "THEN `manager_province`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\n" +
                "WHEN `county_id` = 0\n" +
                "THEN `manager_city`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\n" +
                "ELSE `manager`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\n" +
                "END  as `sum`,\n" +
                "`hight_edu` as `hight_edu`,`sec_edu` as `sec_edu`,`base_edu` as `base_edu`,`sci_edu` as `sci_edu`,`manager` as `manager`\n" +
                "FROM `tempdata`.`tmp_jysy_all`;";

        List<LinkedHashMap<String,String>> all = this.jdbcTemplate.query(getAllSql, (rs, num)->{
            return new LinkedHashMap<String,String>(){{
                put("province_name",rs.getString("province_name"));
                put("city_name",rs.getString("city_name"));
                put("county_name",rs.getString("county_name"));
                put("sum",rs.getString("sum"));
                put("hight_edu",rs.getString("hight_edu"));
                put("sec_edu",rs.getString("sec_edu"));
                put("base_edu",rs.getString("base_edu"));
                put("sci_edu",rs.getString("sci_edu"));
                put("manager",rs.getString("manager"));
            }};
        });

        String getProvinceSql = "SELECT `province_name` as `province_name`,`city_name` as `市`,`county_name` as `county_name`,\n" +
                "CASE WHEN `city_id` = 0 AND `county_id` = 0\n" +
                "THEN `manager_province`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\n" +
                "WHEN `county_id` = 0\n" +
                "THEN `manager_city`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\n" +
                "ELSE `manager`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\n" +
                "END  as `sum`,\n" +
                "`hight_edu` as `hight_edu`,`sec_edu` as `sec_edu`,`base_edu` as `base_edu`,`sci_edu` as `sci_edu`,`manager` as `manager`\n" +
                "FROM `tempdata`.`tmp_jysy_all`\n" +
                "where `city_id`=0;";
        List<LinkedHashMap<String,String>> province = this.jdbcTemplate.query(getProvinceSql,(rs, num)->{
            return new LinkedHashMap<String,String>(){{
                put("province_name", rs.getString("province_name"));
                put("sum", rs.getString("sum"));
                put("hight_edu", rs.getString("hight_edu"));
                put("sec_edu", rs.getString("sec_edu"));
                put("base_edu", rs.getString("base_edu"));
                put("sci_edu", rs.getString("sci_edu"));
                put("manager", rs.getString("manager"));
            }};
        });

        try {
            return provinceService.readOnlineExcel(all, province);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}

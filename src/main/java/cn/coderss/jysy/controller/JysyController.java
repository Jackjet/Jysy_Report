package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.service.ReportProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String detail(String start_date,String end_date,
                         String region, String regionId,
                         String statistics, String sign_ways,
                         String pay_ways, String startDate,String endDate){
        String endDateStr = end_date;
        String startDateStr = start_date;
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
                "            and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "            AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "            LIMIT 1\n" +
                "        ) as `order_states`,\n" +
                "        (\n" +
                "            SELECT `pay_time`\n" +
                "            FROM `vmb_order`  as `order`\n" +
                "            WHERE `order`.`accountid`  = `account`.`accountId` \n" +
                "            AND `order`.`order_states` = 272 \n" +
                "            and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "            AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "            LIMIT 1\n" +
                "        ) as `pay_time`,\n" +
                "        (\n" +
                "            SELECT CASE WHEN COUNT(*)>0 THEN \"已获得\" ELSE \"未获得\" END \n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.starttime <= \'"+endDateStr+" 02:59:59\'\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "            limit 1\n" +
                "        ) as `cer_states`,\n" +
                "        (\n" +
                "            SELECT MIN(`study`.`starttime`) as `time` \n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.starttime <= \'"+endDateStr+" 02:59:59\'\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "        ) as `cer_time`,\n" +
                "        (\n" +
                "            SELECT `study`.`certificate_code`\n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "            AND `study`.starttime <= \'"+endDateStr+" 02:59:59\'\n" +
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
                "            WHERE `study`.sucessfuled=1 AND `study`.valid = 1 AND `study`.starttime <= \'"+endDateStr+" 02:59:59\'\n" +
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
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`"+
                "    )\n" +
                "    and `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
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
            return service.readOnlineExcel(data, region, statistics,
                    sign_ways, pay_ways, startDate, endDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @RequestMapping("/province")
    public String province(String start_date,String end_date,
                           String region, String regionId,
                           String people, String sign_ways, String pay_ways){
        String regionSql = "    SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`,\n" +
                "    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\n" +
                "    `county`.`region_name` as `county_name` ,`county`.`regionid`  as `county_id`\n" +
                "    FROM `vmb_region`  as `province`\n" +
                "    INNER JOIN `vmb_region`  as `city`\n" +
                "    on `city`.`parent_id`  = `province`.`regionid` \n" +
                "    INNER JOIN `vmb_region`  as `county`\n" +
                "    on `county`.`parent_id`  = `city`.`regionid` \n" +
                "UNION ALL \n" +
                "    SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`,\n" +
                "    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n" +
                "    FROM `vmb_region`  as `province`\n" +
                "    INNER JOIN `vmb_region`  as `city`\n" +
                "    on `province`.`regionid`  = `city`.`parent_id`\n" +
                "    WHERE `province`.`parent_id` =0\n" +
                "UNION ALL \n" +
                "    SELECT `province`.`region_name`  as `province_name`,\n" +
                "    `province`.`regionid`  as `province_id` ,\n" +
                "    \"\" as `city_name`,\"\" as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n" +
                "    FROM `vmb_region`  as `province`\n" +
                "    WHERE `parent_id` =0\n" ;
        if(region.equals("全国")){
            regionSql = "SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`," +
                    "    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\n" +
                    "    `county`.`region_name` as `county_name` ,`county`.`regionid`  as `county_id`\n" +
                    "    FROM `vmb_region`  as `province`\n" +
                    "    INNER JOIN `vmb_region`  as `city`\n" +
                    "    on `city`.`parent_id`  = `province`.`regionid` \n" +
                    "    INNER JOIN `vmb_region`  as `county`\n" +
                    "    on `county`.`parent_id`  = `city`.`regionid` \n" +
                    "    WHERE `province`.`regionid` ="+regionId+
                    "UNION ALL \n" +
                    "    SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`,\n" +
                    "    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n" +
                    "    FROM `vmb_region`  as `province`\n" +
                    "    INNER JOIN `vmb_region`  as `city`\n" +
                    "    on `province`.`regionid`  = `city`.`parent_id`\n" +
                    "    WHERE `province`.`regionid`  ="+regionId+"\n" +
                    "UNION ALL \n" +
                    "    SELECT `province`.`region_name`  as `province_name`,\n" +
                    "    `province`.`regionid`  as `province_id` ,\n" +
                    "    \"\" as `city_name`,\"\" as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n" +
                    "    FROM `vmb_region`  as `province`\n" +
                    "    WHERE `province`.`regionid` ="+regionId+"\n" ;
        }
        String endDateStr = "2017-08-07";
        String startDateStr = "2017-06-25";
        String execSql = "INSERT INTO `tempdata`.`tmp_jysy_all`(`province_name`,\n" +
                "    `city_name`,\n" +
                "    `county_name`,\n" +
                "    `hight_edu`,\n" +
                "    `sec_edu`,\n" +
                "    `base_edu`,\n" +
                "    `sci_edu`,\n" +
                "    `manager`,\n" +
                "    `province_id`,\n" +
                "    `city_id`,\n" +
                "    `county_id`,\n" +
                "    `manager_province`,\n" +
                "    `manager_city`,\n" +
                "    `createtime`)\n" +
                "SELECT \n" +
                "    CASE WHEN T.`city_id` = \"\"\n" +
                "    THEN T.`province_name` \n" +
                "    else \"\" end as `province_name`,\n" +
                "    CASE WHEN T.`county_id` = \"\"\n" +
                "    THEN T.`city_name` \n" +
                "    ELSE \"\" end as `city_name`,\n" +
                "    CASE WHEN T.`county_id` != \"\"\n" +
                "    THEN T.`county_name`\n" +
                "    ELSE \"\" end as `county_name`,\n" +
                "    \n" +
                "CASE WHEN T.`county_id` = \"\" and T.`city_id` = \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R200005\"\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    AND `org`.`provinceid`  = T.`province_id`\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "    )\n" +
                ")\n" +
                "ELSE 0  END as `hight_edu`,\n" +
                "CASE WHEN T.`county_id` != \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`))  as `sec_edu`\n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R200006\"\n" +
                "    AND `org`.`countyid`  = T.`county_id`\n" +
                "    AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "WHEN T.`county_id` = \"\" and T.`city_id` != \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`))  as `sec_edu`\n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R200006\"\n" +
                "    AND `org`.`cityid`  = T.`city_id`\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "WHEN T.`county_id` = \"\" and T.`city_id` = \"\" and T.`province_id` != \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`))  as `sec_edu`\n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R200006\"\n" +
                "    AND `org`.`provinceid`  = T.`province_id`\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "ELSE \"\" END as `sec_edu` ,\n" +
                "CASE WHEN T.`county_id` != \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`))  \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` in (\"R200001\",\"R200002\",\"R200003\",\"R200004\")\n" +
                "    and `org`.`countyid`  = T.`county_id`\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "WHEN T.`county_id` = \"\" and T.`city_id` != \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`))  \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` in (\"R200001\",\"R200002\",\"R200003\",\"R200004\")\n" +
                "    AND `org`.`cityid`  = T.`city_id`\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "WHEN T.`county_id` = \"\" and T.`city_id` = \"\" and T.`province_id` != \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`))  \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` in (\"R200001\",\"R200002\",\"R200003\",\"R200004\")\n" +
                "    AND `org`.`provinceid`  = T.`province_id`\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "ELSE \"\" END as `base_edu`,\n" +
                "CASE WHEN T.`county_id` = \"\" and T.`city_id` = \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `member`.`ordId`  = `org`.`orgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R300000\"\n" +
                "    AND `org`.`provinceid`  = T.`province_id`\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "ELSE 0  END AS `sci_edu`,\n" +
                "CASE WHEN T.`county_id` != \"\"\n" +
                "THEN (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `sun_org`\n" +
                "    on `member`.`ordid`  = `sun_org`.`orgId`\n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `org`.`orgid` =`sun_org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId`\n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R100000\" \n" +
                "    AND `sun_org`.`countyid`  = T.`county_id`\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and  `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                ")\n" +
                "WHEN T.`city_id` != \"\"\n" +
                "THEN (\n" +
                "    concat((\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `sun_org`\n" +
                "    on `member`.`ordid`  = `sun_org`.`orgId`\n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `org`.`orgid` =`sun_org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId`\n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R100000\"\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\' \n" +
                "    and `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "    AND `sun_org`.`cityid`  = T.`city_id`),'(',(\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `sun_org`\n" +
                "    on `member`.`ordid`  = `sun_org`.`orgId`\n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `org`.`orgid` =`sun_org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId`\n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R100000\" \n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "    AND `sun_org`.`countyid`  = 0 AND `sun_org`.`cityid`  = T.`city_id`),')')\n" +
                ")\n" +
                "WHEN T.`province_id` != \"\"\n" +
                "THEN (\n" +
                "    CONCAT((\n" +
                "        SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "        FROM `vmb_member` as `member`\n" +
                "        INNER JOIN `vmb_account` as `account`\n" +
                "        on `account`.`accountId`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_org`  as `sun_org`\n" +
                "        on `member`.`ordid`  = `sun_org`.`orgId`\n" +
                "        INNER JOIN `vmb_org`  as `org`\n" +
                "        on `org`.`orgid` =`sun_org`.`parentorgId` \n" +
                "        INNER JOIN `vmb_org` as `parent_org`\n" +
                "        on `parent_org`.`orgId`  = `org`.`parentorgId`\n" +
                "        INNER JOIN `vmb_order` as `order`\n" +
                "        on `order`.`accountid` = `member`.`accountid`\n" +
                "        WHERE `parent_org`.`orgcode` =\"R100000\" \n" +
                "        AND `sun_org`.`provinceid`  = T.`province_id`        \n" +
                "        AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "        AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        and `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    ),'(',(SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `sun_org`\n" +
                "    on `member`.`ordid`  = `sun_org`.`orgId`\n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `org`.`orgid` =`sun_org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId`\n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R100000\" \n" +
                "    AND `sun_org`.`provinceid`  = T.`province_id`\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "    and `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `sun_org`.`countyid`  = 0 and `sun_org`.`cityid`  = 0),')')\n" +
                ")\n" +
                "END as `manager`,T.`province_id` ,T.`city_id`,T.`county_id`,(\n" +
                "        SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "        FROM `vmb_member` as `member`\n" +
                "        INNER JOIN `vmb_account` as `account`\n" +
                "        on `account`.`accountId`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_org`  as `sun_org`\n" +
                "        on `member`.`ordid`  = `sun_org`.`orgId`\n" +
                "        INNER JOIN `vmb_org`  as `org`\n" +
                "        on `org`.`orgid` =`sun_org`.`parentorgId` \n" +
                "        INNER JOIN `vmb_org` as `parent_org`\n" +
                "        on `parent_org`.`orgId`  = `org`.`parentorgId`\n" +
                "        INNER JOIN `vmb_order` as `order`\n" +
                "        on `order`.`accountid` = `member`.`accountid`\n" +
                "        WHERE `parent_org`.`orgcode` =\"R100000\" \n" +
                "        AND `sun_org`.`provinceid`  = T.`province_id`        \n" +
                "        AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "        AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        and `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    ) as `manager_province`,\n" +
                "    (\n" +
                "    SELECT COUNT(DISTINCT(`member`.`accountId`)) \n" +
                "    FROM `vmb_member` as `member`\n" +
                "    INNER JOIN `vmb_account` as `account`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_org`  as `sun_org`\n" +
                "    on `member`.`ordid`  = `sun_org`.`orgId`\n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `org`.`orgid` =`sun_org`.`parentorgId` \n" +
                "    INNER JOIN `vmb_org` as `parent_org`\n" +
                "    on `parent_org`.`orgId`  = `org`.`parentorgId`\n" +
                "    INNER JOIN `vmb_order` as `order`\n" +
                "    on `order`.`accountid` = `member`.`accountid`\n" +
                "    WHERE `parent_org`.`orgcode` =\"R100000\"\n" +
                "    AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \'"+endDateStr+" 02:59:59\' \n" +
                "    and `order`.`pay_time` >= \'"+startDateStr+" 00:00:00\'\n" +
                "    AND `member`.`accountid` in (\n" +
                "        SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \'"+startDateStr+" 00:00:00\'\n" +
                "        AND `entaccount`.`createtime` <= \'"+endDateStr+" 02:59:59\'\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all\n" +
                "        select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        where `pay_time` > \'"+startDateStr+" 00:00:00\'\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "    AND `sun_org`.`cityid`  = T.`city_id`) as `manager_city`,\'"+endDateStr+" 02:59:59\'\n" +
                "FROM (\n" +
                regionSql+
                ")T\n" +
                "ORDER BY T.`province_id` ,T.`city_id`,T.`county_id`;";

        this.jdbcTemplate.execute(execSql);

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



    @RequestMapping("/exec")
    @ResponseBody
    public String exec(String start_date,String end_date, String region, String statistics, String people, String sign_ways, String pay_ways){
        return start_date + end_date + region + people + sign_ways + pay_ways;
    }
}

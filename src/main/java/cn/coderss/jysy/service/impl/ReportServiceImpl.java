package cn.coderss.jysy.service.impl;
/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/24
 * Time: 上午9:38
 * Blog: http://www.coderss.cn
 */
import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.service.ReportProvinceService;
import cn.coderss.jysy.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportDetailService service;
    @Autowired
    ReportProvinceService provinceService;
    private Logger logger = LoggerFactory.getLogger(ReportProvinceServiceImpl.class);
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate secondJdbcTemplate;

    public ReportServiceImpl() {
    }

    public String detail(String start_date, String end_date, String region, String regionId, String statistics, String sign_ways, String pay_ways, String myFilePath, String nowTime) throws Exception {
        String sql = "SELECT TT.`province` as `province`,TT.`city` as `city`,TT.`county` as `country`,TT.`org_custom_name` as `org_custom_name`,\n" +
                "TT.`org_name_second` as `org_name_second`,TT.`org_name` as `org_name`,concat(\"'\",TT.`name`) as `name`,TT.`fullname` as `fullname`,\n" +
                "TT.`sex` as `sex`,concat(\"'\",TT.`birthday` )as `birthday`,concat(\"'\",TT.`mail`) as `mail`,\n" +
                "TT.`position` as `position`,TT.`sign_ways` as `sign_ways`,TT.`createtime` as `createtime`,TT.`order_states` as `order_states`,\n" +
                "TT.`pay_ways` as `pay_ways`,TT.`pay_time` as `pay_time`,\n" +
                "TT.`org_custom_name` as `org_custom_name`,TT.`address` as `address`,\n" +
                "CASE WHEN TT.`periods` is null THEN 0 ELSE TT.`periods` END  as `periods`,\n" +
                "TT.`cer_states` as `cer_states`,TT.`cer_time` as `cer_time`,\n" +
                "concat(\"'\",TT.`cer_code`) as `cer_code`\n" +
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
                "            and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "            AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "            LIMIT 1\n" +
                "        ) as `order_states`,\n" +
                "        (\n" +
                "            SELECT `pay_time`\n" +
                "            FROM `vmb_order`  as `order`\n" +
                "            WHERE `order`.`accountid`  = `account`.`accountId` \n" +
                "            AND `order`.`order_states` = 272 \n" +
                "            and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "            AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "            LIMIT 1\n" +
                "        ) as `pay_time`,\n" +
                "        (\n" +
                "            SELECT CASE WHEN COUNT(*)>0 THEN \"已获得\" ELSE \"未获得\" END \n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.starttime <= \""+end_date+" 23:59:59\"\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "            limit 1\n" +
                "        ) as `cer_states`,\n" +
                "        (\n" +
                "            SELECT MIN(`study`.`starttime`) as `time` \n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.starttime <= \""+end_date+" 23:59:59\"\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "        ) as `cer_time`,\n" +
                "        (\n" +
                "            SELECT `study`.`certificate_code`\n" +
                "            FROM `vmb_studyrecorde` as `study`\n" +
                "            INNER JOIN `vmb_learningactivity`  as `lear`\n" +
                "            on `lear`.`learningActivityId`  = `study`.`learningactivityid` \n" +
                "            WHERE  `lear`.`actType` =200\n" +
                "            AND `study`.`accountid`  = `account`.`accountId` \n" +
                "            AND `study`.starttime <= \""+end_date+" 23:59:59\"\n" +
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
                "            WHERE `study`.sucessfuled=1 AND `study`.valid = 1 AND `study`.starttime <= \""+end_date+" 23:59:59\"\n" +
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
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
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
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "    )\n" +
                "    and `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "    GROUP BY `account`.`accountid`\n" +
                "    ORDER BY `account`.`createtime` DESC \n" +
                ")TT;";
//        this.logger.info(sql);
        sql = "SELECT `tmp_jysy_stu`.`province`,\n" +
                "    `tmp_jysy_stu`.`city`,\n" +
                "    `tmp_jysy_stu`.`county` as `country`,\n" +
                "    `tmp_jysy_stu`.`org_custom_name`,\n" +
                "    `tmp_jysy_stu`.`org_name_second`,\n" +
                "    `tmp_jysy_stu`.`org_name`,\n" +
                "    `tmp_jysy_stu`.`name`,\n" +
                "    `tmp_jysy_stu`.`fullname`,\n" +
                "    `tmp_jysy_stu`.`sex`,\n" +
                "    `tmp_jysy_stu`.`birthday`,\n" +
                "    `tmp_jysy_stu`.`mail`,\n" +
                "    `tmp_jysy_stu`.`position`,\n" +
                "    `tmp_jysy_stu`.`sign_ways`,\n" +
                "    `tmp_jysy_stu`.`createtime`,\n" +
                "    `tmp_jysy_stu`.`order_states`,\n" +
                "    `tmp_jysy_stu`.`pay_ways`,\n" +
                "    `tmp_jysy_stu`.`pay_time`,\n" +
                "    `tmp_jysy_stu`.`address`,\n" +
                "    `tmp_jysy_stu`.`periods`,\n" +
                "    `tmp_jysy_stu`.`cer_states`,\n" +
                "    `tmp_jysy_stu`.`cer_time`,\n" +
                "    `tmp_jysy_stu`.`cer_code`,\n" +
                "    `tmp_jysy_stu`.`mobile`,\n" +
                "    `tmp_jysy_stu`.`createuser`\n" +
                "FROM `tempdata`.`tmp_jysy_stu`;\n";
//        logger.info(sql);
        List<LinkedHashMap<String, String>> data = this.secondJdbcTemplate.query(sql, (rs, num) -> {
            return new LinkedHashMap<String, String>() {
                {
                    this.put("province", rs.getString("province"));
                    this.put("city", rs.getString("city"));
                    this.put("country", rs.getString("country"));
                    this.put("org_custom_name", rs.getString("org_custom_name"));
                    this.put("org_name_second", rs.getString("org_name_second"));
                    this.put("org_name", rs.getString("org_name"));
                    this.put("name", rs.getString("name"));
                    this.put("fullname", rs.getString("fullname"));
                    this.put("sex", rs.getString("sex"));
                    this.put("birthday", rs.getString("birthday"));
                    this.put("mail", rs.getString("mail"));
                    this.put("position", rs.getString("position"));
                    this.put("sign_ways", rs.getString("sign_ways"));
                    this.put("createtime", rs.getString("createtime"));
                    this.put("order_states", rs.getString("order_states"));
                    this.put("pay_ways", rs.getString("pay_ways"));
                    this.put("pay_time", rs.getString("pay_time"));
                    this.put("org_custom_name1", rs.getString("org_custom_name"));
                    this.put("address", rs.getString("address"));
                    this.put("periods", rs.getString("periods"));
                    this.put("cer_states", rs.getString("cer_states"));
                    this.put("cer_time", rs.getString("cer_time"));
                    this.put("cer_code", rs.getString("cer_code"));
                }
            };
        });
        String result = this.service.readOnlineExcel(data, region, statistics, sign_ways, pay_ways, start_date, end_date, myFilePath, nowTime);
        data.clear();
        Runtime.getRuntime().gc();
        return result;
    }

    public String province(String start_date, String end_date, String region, String regionId, String people, String sign_ways, String pay_ways, String myFilePath, String nowTime) throws Exception {
        String delSql = " truncate table tempdata.tmp_jysy_all;";
        this.jdbcTemplate.execute(delSql);
        String regionSql = "SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`,\n    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\n    `county`.`region_name` as `county_name` ,`county`.`regionid`  as `county_id`\n    FROM `vmb_region`  as `province`\n    INNER JOIN `vmb_region`  as `city`\n    on `city`.`parent_id`  = `province`.`regionid` \n    INNER JOIN `vmb_region`  as `county`\n    on `county`.`parent_id`  = `city`.`regionid` \nUNION ALL \n    SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`,\n    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n    FROM `vmb_region`  as `province`\n    INNER JOIN `vmb_region`  as `city`\n    on `province`.`regionid`  = `city`.`parent_id`\n    WHERE `province`.`parent_id` =0\nUNION ALL \n    SELECT `province`.`region_name`  as `province_name`,\n    `province`.`regionid`  as `province_id` ,\n    \"\" as `city_name`,\"\" as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n    FROM `vmb_region`  as `province`\n    WHERE `parent_id` =0\n";
        if(!region.equals("全国")) {
            regionSql = "SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`,    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\n    `county`.`region_name` as `county_name` ,`county`.`regionid`  as `county_id`\n    FROM `vmb_region`  as `province`\n    INNER JOIN `vmb_region`  as `city`\n    on `city`.`parent_id`  = `province`.`regionid` \n    INNER JOIN `vmb_region`  as `county`\n    on `county`.`parent_id`  = `city`.`regionid` \n    WHERE `province`.`regionid` =" + regionId + " \n" + " UNION ALL \n" + "    SELECT `province`.`region_name`  as `province_name`,`province`.`regionid`  as `province_id`,\n" + "    `city`.`region_name`  as `city_name`,`city`.`regionid`  as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n" + "    FROM `vmb_region`  as `province`\n" + "    INNER JOIN `vmb_region`  as `city`\n" + "    on `province`.`regionid`  = `city`.`parent_id`\n" + "    WHERE `province`.`regionid`  =" + regionId + "\n" + " UNION ALL \n" + "    SELECT `province`.`region_name`  as `province_name`,\n" + "    `province`.`regionid`  as `province_id` ,\n" + "    \"\" as `city_name`,\"\" as `city_id`,\"\" as `county_name`, \"\" as `county_id`\n" + "    FROM `vmb_region`  as `province`\n" + "    WHERE `province`.`regionid` =" + regionId + "\n";
        }

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
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    AND `org`.`provinceid`  = T.`province_id`\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and  `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\" \n" +
                "    and `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "            SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
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
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "        AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
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
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "    AND `order`.`order_states` = 272 \n" +
                "    AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "    and `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
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
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "        AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
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
                "    AND `order`.`order_states` = 272 AND `order`.`pay_time` <= \""+end_date+" 23:59:59\" \n" +
                "    and `order`.`pay_time` >= \""+start_date+" 00:00:00\"\n" +
                "    AND `member`.`accountid` in (\n" +
                "        SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \""+start_date+" 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \""+end_date+" 23:59:59\"\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `entaccount`.`states` <> 58        \n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        AND `account`.`accountid` not in (\n" +
                "            SELECT `accountid` FROM `vmb_order` WHERE `pay_ways`  =275 \n" +
                "            AND `order_states` =272 \n" +
                "            AND `pay_time` > \"2016-08-18 00:00:00\"\n" +
                "        )\n" +
                "        \n" +
                "        union all   select `order`.`accountid`\n" +
                "        from `vmb_order` as `order`\n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`accountid`  = `order`.`accountid` \n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `member`.`ordid` \n" +
                "        inner join `vmb_collegeorg` as `colorg` on `colorg`.`orgid` = `org`.`orgid`\n" +
                "        where `pay_time` > \""+start_date+" 00:00:00\"\n" +
                "        and `pay_time` <= \""+end_date+" 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `colorg`.`collegeId` =94\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "        )\n" +
                "    AND `sun_org`.`cityid`  = T.`city_id`) as `manager_city`,\""+end_date+" 23:59:59\"" +
                "FROM (\n" + regionSql + "\n)T\n" + "ORDER BY T.`province_id` ,T.`city_id`,T.`county_id`;";
        this.logger.info(execSql);
        this.jdbcTemplate.update(execSql);
        String getAllSql = "SELECT `province_name` as `province_name`,`city_name` as `city_name`,`county_name` as `county_name`,\nCASE WHEN `city_id` = '0' AND `county_id` = '0'\nTHEN `manager_province`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\nWHEN `county_id` = '0'\nTHEN `manager_city`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\nELSE `manager`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\nEND  as `sum`,\n`hight_edu` as `hight_edu`,`sec_edu` as `sec_edu`,`base_edu` as `base_edu`,`sci_edu` as `sci_edu`,`manager` as `manager`\nFROM `tempdata`.`tmp_jysy_all`;";
        List<LinkedHashMap<String, String>> all = this.secondJdbcTemplate.query(getAllSql, (rs, num) -> {
            return new LinkedHashMap<String, String>() {
                {
                    this.put("province_name", rs.getString("province_name"));
                    this.put("city_name", rs.getString("city_name"));
                    this.put("county_name", rs.getString("county_name"));
                    this.put("sum", rs.getString("sum"));
                    this.put("hight_edu", rs.getString("hight_edu"));
                    this.put("sec_edu", rs.getString("sec_edu"));
                    this.put("base_edu", rs.getString("base_edu"));
                    this.put("sci_edu", rs.getString("sci_edu"));
                    this.put("manager", rs.getString("manager"));
                }
            };
        });
        String getProvinceSql = "SELECT `province_name` as `province_name`,`city_name` as `市`,`county_name` as `county_name`,\nCASE WHEN `city_id` = '' AND `county_id` = ''\nTHEN `manager_province`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\nWHEN `county_id` = ''\nTHEN `manager_city`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\nELSE `manager`+`hight_edu`+`sec_edu`+`base_edu`+`sci_edu`\nEND  as `sum`,\n`hight_edu` as `hight_edu`,`sec_edu` as `sec_edu`,`base_edu` as `base_edu`,`sci_edu` as `sci_edu`,`manager` as `manager`\nFROM `tempdata`.`tmp_jysy_all`\nwhere `city_id`='';";
        List<LinkedHashMap<String, String>> province = this.secondJdbcTemplate.query(getProvinceSql, (rs, num) -> {
            return new LinkedHashMap<String, String>() {
                {
                    this.put("province_name", rs.getString("province_name"));
                    this.put("sum", rs.getString("sum"));
                    this.put("hight_edu", rs.getString("hight_edu"));
                    this.put("sec_edu", rs.getString("sec_edu"));
                    this.put("base_edu", rs.getString("base_edu"));
                    this.put("sci_edu", rs.getString("sci_edu"));
                    this.put("manager", rs.getString("manager"));
                }
            };
        });
        String result = this.provinceService.readOnlineExcel(all, province, myFilePath, nowTime, start_date, end_date);
        all.clear();
        province.clear();
        Runtime.getRuntime().gc();
        return result;
    }
}


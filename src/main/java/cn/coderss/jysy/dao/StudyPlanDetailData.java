package cn.coderss.jysy.dao;

import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/9/4
 * Time: 上午9:39
 * Blog: http://www.coderss.cn
 */
@Repository
@Scope("singleton")
public class StudyPlanDetailData {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    Logger logger = LoggerFactory.getLogger(StudyPlanDetailData.class);

    List<String> studyPlanCodeList = new ArrayList<>();

    List<String> needFields = new ArrayList<>(Arrays.asList("scorm_score", "certificate_status",
            "certificate_time", "certificate_code"));
    List<String> fields = new ArrayList<>();

    List<String> codeStudyNameScoreNameNeedFields = Arrays.asList("studyplan_name", "scorm_name");
    public List<String> outerFields = new ArrayList<>();

    public List<String> getOuterFields() {
        return outerFields;
    }

    public void setOuterFields(List<String> outerFields) {
        this.outerFields = outerFields;
    }

    public List<LinkedHashMap<String,String>> getData(StudyPlanDetailReqModel model){
        //增加编码进去
        studyPlanCodeList.addAll(Arrays.asList(model.getCode().split(",")));

        String sql = dealSql();
        logger.info(sql);

        //增加实际的字段
        for (String code:studyPlanCodeList){
            for (String field: needFields){
                StringBuilder tmp = new StringBuilder();
                tmp.append(code).append("_").append(field);
                fields.add(tmp.toString());
            }
            for (String scormNameStudyNameField : codeStudyNameScoreNameNeedFields){
                StringBuilder tmp = new StringBuilder();
                tmp.append(code).append("_").append(scormNameStudyNameField);
                fields.add(tmp.toString());
                outerFields.add(tmp.toString());
            }
        }


        //数据抽取
        List<LinkedHashMap<String,String>> list = this.primaryJdbcTemplate.query(sql, (rs, num)->{
            return new LinkedHashMap<String,String>(){{
                put("province", rs.getString("province"));
                put("city", rs.getString("city"));
                put("country", rs.getString("country"));
                put("org_custom_name", rs.getString("org_custom_name"));
                put("org_name_second", rs.getString("org_name_second"));
                put("org_name", rs.getString("org_name"));
                put("name", rs.getString("name"));
                put("fullname", rs.getString("fullname"));
                for (String field: fields){
                    put(field, rs.getString(field));
                }

            }};
        });
        logger.info(outerFields.toString());
        return list;
    }

    public String dealSql(){

        List<String> fields = Arrays.asList("account_name", "studyplan_name",
                "scorm_name", "scorm_score",
                "certificate_name", "certificate_status",
                "certificate_time", "certificate_code");
        StringBuilder innerSelectSql = new StringBuilder();
        for (String studyPlanCode:studyPlanCodeList){
            for (int i=0; i<fields.size(); i++){
                innerSelectSql.append("`").append(studyPlanCode).append("`.").append(fields.get(i)).append(" as `").append(studyPlanCode).append("_").append(fields.get(i)).append("`");
                innerSelectSql.append(",");
            }
        }
        innerSelectSql.delete(innerSelectSql.length()-1, innerSelectSql.length());
        StringBuilder outterSelectSql = new StringBuilder();
        for (String studyPlanCode:studyPlanCodeList){
            for (int i=0; i<fields.size(); i++){
                outterSelectSql.append("TT.").append(studyPlanCode).append("_").append(fields.get(i));
                outterSelectSql.append(",");
            }
        }
        outterSelectSql.delete(outterSelectSql.length()-1, outterSelectSql.length());

        StringBuilder joinSql = new StringBuilder();
        for (String studyPlanCode:studyPlanCodeList){
            joinSql.append("Left join `vmobel`.`cache_jysy_account_studyplan_certificate` as ")
                    .append(studyPlanCode)
                    .append("   on `").append(studyPlanCode).append("`.`accountid`=`account`.`accountid`\n")
                    .append("and `").append(studyPlanCode).append("`.`studyplan_code` = '").append(studyPlanCode).append("' \n");
        }

        String sql = "SELECT TT.accountid,TT.`province` as `province`,TT.`city` as `city`,TT.`county` as `country`,TT.`org_custom_name` as `org_custom_name`,\n" +
                "TT.`org_name_second` as `org_name_second`,TT.`org_name` as `org_name`,TT.`name` as `name`,TT.`fullname` as `fullname`,\n" +
                outterSelectSql+
                " FROM (\n" +
                "    SELECT \n" +
                " account.accountid," +
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
                innerSelectSql+
                "FROM `vmb_account` as `account`\n" +
                "    INNER JOIN `vmb_member` as `member`\n" +
                "    on `account`.`accountId`  = `member`.`accountId` \n" +
                "    INNER JOIN `vmb_collegeorg`  as `colorg`\n" +
                "    on `colorg`.`orgId`  = `member`.`ordId` \n" +
                "    INNER JOIN `vmb_org`  as `org`\n" +
                "    on `org`.`orgId`  =`member`.`ordId` \n" +
                "    INNER JOIN `vmb_enterpriseaccount` as `entaccount` \n" +
                "    on `entaccount`.`accountid` = `account`.`accountid`\n" +
                joinSql+
                "    WHERE `colorg`.`collegeId` =94\n" +
                "    and `entaccount`.`enterpriseid`=11\n" +
                "    AND `account`.`accountid` in (\n" +
                "        SELECT DISTINCT(`account`.`accountId`)\n" +
                "        FROM `vmb_collegeorg` as `colorg`\n" +
                "        INNER JOIN `vmb_org`  as `org` on `org`.`orgId`  = `colorg`.`orgId` \n" +
                "        INNER JOIN `vmb_member`  as `member` on `member`.`ordId`  = `org`.`orgId` \n" +
                "        INNER JOIN `vmb_enterpriseaccount`  as `entaccount` on `entaccount`.`accountid`  = `member`.`accountId` \n" +
                "        INNER JOIN `vmb_account`  as `account` on `account`.`accountId`  = `member`.`accountId` \n" +
                "        WHERE `entaccount`.`createtime`>= \"2017-06-01 00:00:00\"\n" +
                "        AND `entaccount`.`createtime` <= \"2017-09-01 23:59:59\"\n" +
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
                "        where `pay_time` > \"2017-06-01 00:00:00\"\n" +
                "        and `pay_time` <= \"2017-09-01 23:59:59\"\n" +
                "        and `pay_ways`  !=275 AND `order_states` =272\n" +
                "        AND `org`.`name` not in (\"易知\",\"系统管理员\",\"教育事业试用账号\",\"6月28号演示\",\"免费账号\")\n" +
                "        GROUP BY `order`.`accountid`\n" +
                "    )\n" +
                "    and `entaccount`.`createtime` <= \"2017-09-01 23:59:59\"\n" +
                "    GROUP BY `account`.`accountid`\n" +
                "    ORDER BY `account`.`createtime` DESC \n" +
                ")TT group by `TT`.`accountid`";
        return sql;
    }
}

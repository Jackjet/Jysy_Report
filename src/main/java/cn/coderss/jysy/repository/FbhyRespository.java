package cn.coderss.jysy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/3
 * Time: 下午2:15
 * Blog: http://www.coderss.cn
 */
@Repository
public class FbhyRespository {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<LinkedHashMap<String,String>> getLoginlog(){
        String sql = "SELECT `account`.`name` ,`account`.`fullname` ,`org`.`name`  as `org_name`,\n" +
                "`log`.`createtime` ,`log`.`terminal` \n" +
                "FROM `vmb_account` as `account`\n" +
                "INNER JOIN `login_log` as `log` on `log`.`name`  = `account`.`name` \n" +
                "INNER JOIN `vmb_member` as `member` on `member`.`accountId`  = `account`.`accountId` \n" +
                "INNER JOIN `vmb_org` as `org` on `org`.`orgId`  = `member`.`ordId` \n" +
                "INNER JOIN `vmb_collegeorg` as `colorg` on `colorg`.`orgId`  = `member`.`ordId` \n" +
                "INNER JOIN `vmb_college` as `college` on `college`.`collegeId`  = `colorg`.`collegeId` \n" +
                "WHERE `log`.`createtime` >\"2017-05-01 00:00:00\"\n" +
                "AND `log`.`createtime` <\"2017-06-01 00:00:00\"\n" +
                "AND `college`.`code` =\"fbhy\"\n" +
                "GROUP BY `log`.`logid` ;";
        return this.jdbcTemplate.query(sql, (rs, num)->{
            return new LinkedHashMap<String, String>(){{
                put("name", rs.getString("name"));
                put("fullname", rs.getString("fullname"));
                put("org_name", rs.getString("org_name"));
                put("createtime", rs.getString("createtime"));
                put("terminal", rs.getString("terminal"));
            }};
        });
    }
}

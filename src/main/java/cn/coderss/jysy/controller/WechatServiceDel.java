package cn.coderss.jysy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/5
 * Time: 下午3:42
 * Blog: http://www.coderss.cn
 */
@RestController
@RequestMapping("/wechat")
public class WechatServiceDel {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin(value = "*")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delService(String content){
        String regex = "([a-z]|[A-Z]|[0-9])*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        StringBuilder stringBuilder = new StringBuilder();
        while (m.find()){
            if(!m.group().equals("")){
                stringBuilder.append("'"+m.group()+"',");
            }
        }
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        String sql = "SELECT `info`.`infoid`\n" +
                "FROM `vmb_account` as `account`\n" +
                "INNER JOIN `wechat_service`.`wechat_user_info` as `info` on `info`.`accountId`  = `account`.`accountId` \n" +
                "WHERE `account`.`name` in (\n" +
                stringBuilder.toString()+");\n";

        List<String> data =this.jdbcTemplate.query(sql, (rs, num)->
            new String("delete from `wechat_service`.`wechat_user_info` " +
                    "where `infoid` ="+rs.getString("infoid"))
        );

        for (String itemSql : data){
            this.jdbcTemplate.execute(itemSql);
        }


        sql =  "SELECT `token`.*\n" +
                "FROM `vmb_account` as `account`\n" +
                "INNER JOIN `wechat_service`.`wechat_service_token`  as `token` on `token`.`accountId`  = `account`.`accountId` \n" +
                "WHERE `account`.`name` in (\n" +
                stringBuilder+");";
        data = this.jdbcTemplate.query(sql ,(rs, num)->
                new String("delete from `wechat_service`.`wechat_service_token` " +
                "where `tokenid` ="+rs.getString("tokenid"))
        );

        for (String itemSql : data){
            this.jdbcTemplate.execute(itemSql);
        }

        return "ok";
    }

    public static void main(String[] args) {

    }
}

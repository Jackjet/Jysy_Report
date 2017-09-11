package cn.coderss.jysy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/9/11
 * Time: 下午3:52
 * Blog: http://www.coderss.cn
 */
@Repository
public class StudyPlanNameCode {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;


    public LinkedHashMap<String,String> getNameAndCode(){
        List<LinkedHashMap<String,String>> data =
                primaryJdbcTemplate.query("select `lear`.`code` as `studyPlanCode`,`lear`.`name` as `studyPlanName`,\n" +
                        "max(`rel_lear`.`name`) as `scormName`\n" +
                        "from vmobel.vmb_learningactivity as `lear`\n" +
                        "left join vmobel.vmb_issue as `issue` on `issue`.learningactivityid = `lear`.`learningActivityId`\n" +
                        "left join vmobel.vmb_issueactivity as `issueactivity` on `issueactivity`.`issueid` = `issue`.`issueid`\n" +
                        "and `issue`.`code`=\"04\"\n" +
                        "left join vmobel.vmb_learningactivity as `rel_lear` on `rel_lear`.`learningActivityId`=`issueactivity`.`rel_activityid`\n" +
                        "where `lear`.`code` in (\n" +
                        "'yanshi20160623',\n" +
                        "'yanshi20160725',\n" +
                        "'yanshi2016061501',\n" +
                        "'yanshi2016061502',\n" +
                        "'yanshi2016061503',\n" +
                        "'yanshi2016061502copy',\n" +
                        "'tsjy',\n" +
                        "'yanshi20160624',\n" +
                        "'yanshi2016072501',\n" +
                        "'dsjjyxzbm',\n" +
                        "'yanshi2017061901',\n" +
                        "'yanshi2017062001',\n" +
                        "'yanshi2017062002',\n" +
                        "'yanshi2017062003',\n" +
                        "'yanshi2017062004',\n" +
                        "'yanshi2017062005',\n" +
                        "'yanshi2017062006',\n" +
                        "'yanshi2017062007',\n" +
                        "'yanshi2017062008',\n" +
                        "'yanshi2017062009',\n" +
                        "'yanshi2017062010',\n" +
                        "'yanshi2017062011')\n" +
                        "group by `lear`.`code`;;", (rs,num)->{
            return new LinkedHashMap<String,String>(){{
                put(rs.getString("studyPlanCode"), rs.getString("studyPlanName")
                        .concat(",")
                        .concat(rs.getString("scormName")== null? "": rs.getString("scormName")));
            }};
                });
        LinkedHashMap<String,String> newData = new LinkedHashMap<>();
        data.stream().forEach(item->{
            for (Map.Entry<String,String> entry: item.entrySet()){
                newData.put(entry.getKey(), entry.getValue());
            }
        });

        return newData;
    }
}

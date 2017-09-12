package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.service.ReportStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/9/12
 * Time: 下午3:04
 * Blog: http://www.coderss.cn
 */
@Service
public class ReportStopServiceImpl implements ReportStopService {

    @Autowired
    @Qualifier("thirdJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Override
    public void stopReportService(){
        String sql = "UPDATE `vmobel`.`celery_taskinfo` SET `result_states`=118\n" +
                "WHERE `result_states`=120 \n" +
                "and `type`=322;";
        jdbcTemplate.execute(sql);
        String stopSql = "UPDATE `vmobel`.`celery_taskinfo` SET `result_states`=118\n" +
                "WHERE `result_states`=120 \n" +
                "and `type`=323;";
        jdbcTemplate.execute(stopSql);

    }
}

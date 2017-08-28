package cn.coderss.jysy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/18
 * Time: 下午12:20
 * Blog: http://www.coderss.cn
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    public DruidDataSource primaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.primary.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.primary.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.primary.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.primary.driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(2);
        dataSource.setMinIdle(1);
        dataSource.setMaxWait(6000000);
        dataSource.setMinEvictableIdleTimeMillis(320000);
        dataSource.setMaxEvictableIdleTimeMillis(320000);
        dataSource.setTimeBetweenEvictionRunsMillis(300000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(300);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

    @Bean(name = "thirdDataSource")
    @Qualifier("thirdDataSource")
    public DruidDataSource thridDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.third.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.third.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.third.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.third.driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(2);
        dataSource.setMinIdle(1);
        dataSource.setMaxWait(6000000);
        dataSource.setMinEvictableIdleTimeMillis(320000);
        dataSource.setMaxEvictableIdleTimeMillis(320000);
        dataSource.setTimeBetweenEvictionRunsMillis(300000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(300);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    public DruidDataSource secondaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.secondary.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.secondary.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.secondary.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.secondary.driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(2);
        dataSource.setMinIdle(1);
        dataSource.setMaxWait(6000000);
        dataSource.setMinEvictableIdleTimeMillis(320000);
        dataSource.setMaxEvictableIdleTimeMillis(320000);
        dataSource.setTimeBetweenEvictionRunsMillis(300000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(300);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "thirdJdbcTemplate")
    public JdbcTemplate thirdJdbcTemplate(@Qualifier("thirdDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

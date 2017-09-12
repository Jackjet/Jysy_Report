package cn.coderss.jysy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午2:45
 * Blog: http://www.coderss.cn
 */
@SpringBootApplication
@EnableTransactionManagement
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}

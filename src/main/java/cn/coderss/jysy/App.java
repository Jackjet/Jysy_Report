package cn.coderss.jysy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午2:45
 * Blog: http://www.coderss.cn
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.coderss.jysy.mapper")
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}

package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.FbhyService;
import cn.coderss.jysy.utility.NettyTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/3
 * Time: 下午2:47
 * Blog: http://www.coderss.cn
 */
@Api(value = "富邦华一接口")
@Controller
@RequestMapping("/fbhy")
public class FbhyController {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondJdbcTemplate;

    @Autowired
    FbhyService fbhyService;

    @ApiOperation(value = "登录相关资料数据", notes = "富邦华一登录数据明细")
    @GetMapping(value = "/loginreport")
    public String getLoginData(){
        String fileName = fbhyService.loginLogReport();
        return "redirect:/report/"+fileName;
    }

    @GetMapping(value = "/data2")
    @ResponseBody
    public HashMap<String,String> getData2(){
        return new HashMap<String, String>(){{
            put("message", "msg");
            put("code", "ok");
            put("content", NettyTool.getWebContentByUrl("http://www.baidu.com?"+ UUID.randomUUID()));
        }};
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> getUserAccounts() throws Exception {
        return Optional.ofNullable(new HashMap<String, String>() {{
            put("message", "code");
            put("states", "1");
        }}).map(data -> new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK))
                .orElseThrow(() -> new Exception("data error"));
    }


    @GetMapping(value = "/test2")
    @ResponseBody
    public Flux<HashMap<String,String>> getTest2(){
        List<HashMap<String,String>> data = this.jdbcTemplate.query("select * from vmb_account where accountid=51630 limit 1;",(rs, num)->{
            return new HashMap<String,String>(){{
                put("fullname", rs.getString("fullname"));
            }};
        });
        return Flux.fromIterable(data);
    }

    @GetMapping(value = "/test3")
    @ResponseBody
    public Flux<HashMap<String,String>> getTest3(){
        List<HashMap<String,String>> data = this.secondJdbcTemplate.query("select * from vmb_account where accountid=51630 limit 1;",(rs, num)->{
            return new HashMap<String,String>(){{
                put("fullname", rs.getString("fullname"));
            }};
        });
        return Flux.fromIterable(data);
    }


    @GetMapping(value = "/data")
    @ResponseBody
    public Mono<HashMap<String,String>> getData(){
        return Mono.just(new HashMap<String, String>(){{
            put("message", "msg");
            put("code", "ok");
            put("content", NettyTool.getWebContentByUrl("http://www.baidu.com?"+ UUID.randomUUID()));
        }});
    }
}

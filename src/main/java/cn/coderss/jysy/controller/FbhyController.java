package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.FbhyService;
import cn.coderss.jysy.utility.NettyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/3
 * Time: 下午2:47
 * Blog: http://www.coderss.cn
 */
@RestController
@RequestMapping("/fbhy")
public class FbhyController {
    @Autowired
    FbhyService fbhyService;

    @GetMapping(value = "/loginreport")
    public String getLoginData(){
        String fileName = fbhyService.loginLogReport();
        return "redirect:/"+fileName;
    }

    @GetMapping(value = "/data2")
    public HashMap<String,String> getData2(){
        return new HashMap<String, String>(){{
            put("message", "msg");
            put("code", "ok");
            put("content", NettyTool.getWebContentByUrl("http://www.baidu.com?"+ UUID.randomUUID()));
        }};
    }

    @GetMapping(value = "/test")
    public ResponseEntity<HashMap<String,String>> getUserAccounts() throws Exception {
        return Optional.ofNullable(new HashMap<String, String>() {{
            put("message", "code");
            put("states", "1");
        }}).map(data -> new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK))
                .orElseThrow(() -> new Exception("data error"));
    }


    @GetMapping(value = "/data")
    public Mono<HashMap<String,String>> getData(){
        return Mono.just(new HashMap<String, String>(){{
            put("message", "msg");
            put("code", "ok");
            put("content", NettyTool.getWebContentByUrl("http://www.baidu.com?"+ UUID.randomUUID()));
        }});
    }
}

package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.FbhyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

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

    @GetMapping(value = "/test")
    public ResponseEntity<HashMap<String,String>> getUserAccounts() throws Exception {
        return Optional.ofNullable(new HashMap<String, String>() {{
            put("message", "code");
            put("states", "1");
        }}).map(data -> new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK))
                .orElseThrow(() -> new Exception("data error"));
    }
//    @GetMapping(value = "/loginreport_stream")
//    public InputStream getLoginDataStream(){
//        fbhyService.loginLogReportStream();
//    }
}

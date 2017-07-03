package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.FbhyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

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

//    @GetMapping(value = "/loginreport_stream")
//    public InputStream getLoginDataStream(){
//        fbhyService.loginLogReportStream();
//    }
}

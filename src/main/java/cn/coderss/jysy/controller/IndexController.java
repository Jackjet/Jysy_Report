package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.service.ReportProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午2:47
 * Blog: http://www.coderss.cn
 */
@Controller
public class IndexController {
    @Autowired
    ReportDetailService reportDetailService;

    @Autowired
    ReportProvinceService reportProvinceService;

    @GetMapping("/")
    public String index(Model m, String name) {
        if(name == null){
           name = "";
        }
        m.addAttribute("name", name);
        return "index";
    }

    @PostMapping("/detail")
    @ResponseBody
    public String detail(MultipartFile file) throws UnsupportedEncodingException {
        return reportDetailService.doExcel(file);
    }

    @PostMapping("/province")
    @ResponseBody
    public String province(MultipartFile file) throws UnsupportedEncodingException {
        return reportProvinceService.doExcel(file);
    }
}

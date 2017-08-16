package cn.coderss.jysy.controller;

import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.service.ReportProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午2:47
 * Blog: http://www.coderss.cn
 */
@Api("默认首页")
@Controller
public class IndexController {
    @Autowired
    ReportDetailService reportDetailService;

    @Autowired
    ReportProvinceService reportProvinceService;


    @ApiOperation(value = "首页默认页面")
    @GetMapping("/")
    public String index(Model m, String name) {
        if(name == null){
           name = "";
        }
        m.addAttribute("name", name);
        return "index";
    }

    @ApiOperation("教育事业-详情xlsx切割")
    @PostMapping("/detail")
    public String detail(MultipartFile file) throws UnsupportedEncodingException {
        return reportDetailService.doExcel(file, "");
    }

    @ApiOperation("教育事业-省份相关xlsxl切割")
    @PostMapping("/province")
    public String province(MultipartFile file) throws UnsupportedEncodingException {
        return reportProvinceService.doExcel(file, "");
    }


    @GetMapping("/report_detail")
    public String reportDetail(){
        return "report_detail";
    }
}

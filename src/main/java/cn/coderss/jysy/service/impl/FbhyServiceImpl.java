package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.repository.FbhyRespository;
import cn.coderss.jysy.service.FbhyService;
import cn.coderss.jysy.utility.ExcelUtilitys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/3
 * Time: 下午2:43
 * Blog: http://www.coderss.cn
 */
@Service
public class FbhyServiceImpl implements FbhyService{
    @Autowired
    FbhyRespository fbhyRespository;

    @Override
    public String loginLogReport() {
        ArrayList<LinkedHashMap<String,String>> data = (ArrayList<LinkedHashMap<String, String>>) fbhyRespository.getLoginlog();
        return ExcelUtilitys.writeExcel("./downloads", data);
    }


    public FileInputStream loginLogReportStream(){
        ArrayList<LinkedHashMap<String,String>> data = (ArrayList<LinkedHashMap<String, String>>) fbhyRespository.getLoginlog();
        return ExcelUtilitys.writeExcelStream("./downloads", data);
    }
}

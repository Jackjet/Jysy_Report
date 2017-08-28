package cn.coderss.jysy.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午3:02
 * Blog: http://www.coderss.cn
 */
public interface ReportDetailService {
    void readExcel(String var1) throws Exception;

    String readOnlineExcel(List<LinkedHashMap<String, String>> var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) throws Exception;

    void writeExcel(String var1) throws Exception;

    String doExcel(MultipartFile var1, String var2) throws UnsupportedEncodingException;
}

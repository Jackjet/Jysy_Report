package cn.coderss.jysy.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午2:55
 * Blog: http://www.coderss.cn
 */
public interface ReportProvinceService {
    void readExcel(String var1);

    void writeExcel(String var1, String var2, String var3);

    String readOnlineExcel(List<LinkedHashMap<String, String>> var1, List<LinkedHashMap<String, String>> var2, String var3, String var4, String var5, String var6) throws IOException;

    String doExcel(MultipartFile var1, String var2) throws UnsupportedEncodingException;
}

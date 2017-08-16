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
    public void readExcel(String inputFile);
    public void writeExcel(String outFile);
    public String readOnlineExcel(List<LinkedHashMap<String, String>> data,
                                  List<LinkedHashMap<String, String>> province,
                                  String myFilePath,
                                  String nowTime) throws IOException;
    public String doExcel(MultipartFile file, String myFilePath) throws UnsupportedEncodingException;
}

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
    public void readExcel(String filename) throws IOException;
    public void readOnlineExcel(List<LinkedHashMap<String, String>> data) throws IOException;
    public void writeExcel(String filepath) throws IOException;
    public String doExcel(MultipartFile file) throws UnsupportedEncodingException;
}

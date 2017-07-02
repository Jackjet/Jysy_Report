package cn.coderss.jysy.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

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
    public String doExcel(MultipartFile file) throws UnsupportedEncodingException;
}

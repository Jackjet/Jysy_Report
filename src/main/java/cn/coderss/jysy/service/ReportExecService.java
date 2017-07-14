package cn.coderss.jysy.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/10
 * Time: 下午4:30
 * Blog: http://www.coderss.cn
 */
public interface ReportExecService {
    public void readExcel(String filename);
    public  String doExcel(MultipartFile file);
    public void test();
}

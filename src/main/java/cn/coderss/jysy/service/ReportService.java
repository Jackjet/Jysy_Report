package cn.coderss.jysy.service;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/16
 * Time: 下午1:24
 * Blog: http://www.coderss.cn
 */
public interface ReportService {
    public String province(String start_date,String end_date,
                           String region, String regionId,
                           String people, String sign_ways,
                           String pay_ways, String myFilePath,
                           String nowTime);

    public String detail(String start_date,String end_date,
                         String region, String regionId,
                         String statistics, String sign_ways,
                         String pay_ways, String myFilePath,
                         String nowTime);
}

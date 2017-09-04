package cn.coderss.jysy.reqmodel;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/9/4
 * Time: 上午9:25
 * Blog: http://www.coderss.cn
 */
public class StudyPlanDetailReqModel {
    public String startDate;
    public String endDate;
    public String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}

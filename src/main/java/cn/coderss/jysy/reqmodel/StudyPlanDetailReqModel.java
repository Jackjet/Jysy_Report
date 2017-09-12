package cn.coderss.jysy.reqmodel;

import javax.validation.constraints.NotNull;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/9/4
 * Time: 上午9:25
 * Blog: http://www.coderss.cn
 */
public class StudyPlanDetailReqModel {
    @NotNull(message="开始日期不能为空")
    private String startDate;

    @NotNull(message="截止日期不能为空")
    private String endDate;

    @NotNull(message="学习计划编码不能为空")
    private String code;

    private String uuidCode;

    @NotNull(message="用户唯一主键不能为空")
    private String accountid;

    @NotNull(message="学院唯一主键不能为空")
    private String collegeid;

    @NotNull(message="企业唯一主键不能为空")
    private String enterpriseid;

    @NotNull(message="统计人群不能为空")
    private String people;

    @NotNull(message="地区不能为空")
    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(String collegeid) {
        this.collegeid = collegeid;
    }

    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public String getUuidCode() {
        return uuidCode;
    }

    public void setUuidCode(String uuidCode) {
        this.uuidCode = uuidCode;
    }

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

    @Override
    public String toString() {
        return "StudyPlanDetailReqModel{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", code='" + code + '\'' +
                ", uuidCode='" + uuidCode + '\'' +
                ", accountid='" + accountid + '\'' +
                ", collegeid='" + collegeid + '\'' +
                ", enterpriseid='" + enterpriseid + '\'' +
                ", people='" + people + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}

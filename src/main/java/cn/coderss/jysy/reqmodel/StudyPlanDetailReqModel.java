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
    public String uuidCode;
    public String accountid;
    public String collegeid;
    public String enterpriseid;
    public String people;

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

}

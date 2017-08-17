package cn.coderss.jysy.reqmodel;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/16
 * Time: 下午1:31
 * Blog: http://www.coderss.cn
 */
public class JysyReqModel {
    public String start_date;
    public String end_date;
    public String region;
    public String regionId;
    public String people;
    public String sign_ways;
    public String pay_ways;
    public String accountid;
    public String collegeid;
    public String enterpriseid;

    @Override
    public String toString() {
        return "JysyReqModel{" +
                "start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", region='" + region + '\'' +
                ", regionId='" + regionId + '\'' +
                ", people='" + people + '\'' +
                ", sign_ways='" + sign_ways + '\'' +
                ", pay_ways='" + pay_ways + '\'' +
                ", accountid='" + accountid + '\'' +
                ", collegeid='" + collegeid + '\'' +
                ", enterpriseid='" + enterpriseid + '\'' +
                '}';
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getSign_ways() {
        return sign_ways;
    }

    public void setSign_ways(String sign_ways) {
        this.sign_ways = sign_ways;
    }

    public String getPay_ways() {
        return pay_ways;
    }

    public void setPay_ways(String pay_ways) {
        this.pay_ways = pay_ways;
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
}

package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_accountcollegeactive")
public class CacheAccountcollegeactive {
    private Integer accountid;

    private Integer memberid;

    private Integer collegeid;

    private Integer orgid;

    private Integer enterpriseid;

    /**
     * @return accountid
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * @return memberid
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * @param memberid
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * @return collegeid
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * @param collegeid
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * @return orgid
     */
    public Integer getOrgid() {
        return orgid;
    }

    /**
     * @param orgid
     */
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    /**
     * @return enterpriseid
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_accountcollegeactive")
public class VwAccountcollegeactive {
    private Byte accountid;

    private Byte memberid;

    @Column(name = "orgId")
    private Byte orgid;

    @Column(name = "collegeId")
    private Byte collegeid;

    @Column(name = "enterpriseId")
    private Byte enterpriseid;

    /**
     * @return accountid
     */
    public Byte getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Byte accountid) {
        this.accountid = accountid;
    }

    /**
     * @return memberid
     */
    public Byte getMemberid() {
        return memberid;
    }

    /**
     * @param memberid
     */
    public void setMemberid(Byte memberid) {
        this.memberid = memberid;
    }

    /**
     * @return orgId
     */
    public Byte getOrgid() {
        return orgid;
    }

    /**
     * @param orgid
     */
    public void setOrgid(Byte orgid) {
        this.orgid = orgid;
    }

    /**
     * @return collegeId
     */
    public Byte getCollegeid() {
        return collegeid;
    }

    /**
     * @param collegeid
     */
    public void setCollegeid(Byte collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * @return enterpriseId
     */
    public Byte getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Byte enterpriseid) {
        this.enterpriseid = enterpriseid;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_profile")
public class VmbProfile {
    @Id
    @Column(name = "profileId")
    private Integer profileid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * @return profileId
     */
    public Integer getProfileid() {
        return profileid;
    }

    /**
     * @param profileid
     */
    public void setProfileid(Integer profileid) {
        this.profileid = profileid;
    }

    /**
     * @return enterpriseId
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

    /**
     * @return collegeId
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
     * @return accountId
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
}
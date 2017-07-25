package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_accountcollegeorg_tmp")
public class CacheAccountcollegeorgTmp {
    @Id
    private Integer accountid;

    @Id
    private Integer collegeid;

    @Id
    private Integer enterpriseid;

    private String orgname;

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

    /**
     * @return orgname
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * @param orgname
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cache_account_info")
public class CacheAccountInfo {
    @Id
    private Integer id;

    private Integer accountid;

    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    @Column(name = "college_id")
    private Integer collegeId;

    private Integer orgid;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_fullname")
    private String accountFullname;

    @Column(name = "account_status")
    private Integer accountStatus;

    @Column(name = "account_createtime")
    private Date accountCreatetime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return enterprise_id
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * @return college_id
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * @param collegeId
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
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
     * @return account_name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return account_fullname
     */
    public String getAccountFullname() {
        return accountFullname;
    }

    /**
     * @param accountFullname
     */
    public void setAccountFullname(String accountFullname) {
        this.accountFullname = accountFullname;
    }

    /**
     * @return account_status
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * @param accountStatus
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * @return account_createtime
     */
    public Date getAccountCreatetime() {
        return accountCreatetime;
    }

    /**
     * @param accountCreatetime
     */
    public void setAccountCreatetime(Date accountCreatetime) {
        this.accountCreatetime = accountCreatetime;
    }
}
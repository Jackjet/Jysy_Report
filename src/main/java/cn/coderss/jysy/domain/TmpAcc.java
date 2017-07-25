package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "tmp_acc")
public class TmpAcc {
    @Id
    private Integer id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_fullname")
    private String accountFullname;

    @Column(name = "account_status")
    private Integer accountStatus;

    private Integer accountid;

    @Column(name = "college_id")
    private Integer collegeId;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "name_path")
    private String namePath;

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
     * @return org_name
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return name_path
     */
    public String getNamePath() {
        return namePath;
    }

    /**
     * @param namePath
     */
    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }
}
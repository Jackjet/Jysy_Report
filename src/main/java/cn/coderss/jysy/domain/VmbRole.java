package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_role")
public class VmbRole {
    @Id
    @Column(name = "roleId")
    private Integer roleid;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 是否有效
     */
    private Boolean valid;

    private Date createtime;

    private Boolean isopr;

    @Column(name = "permissionGroupId")
    private Integer permissiongroupid;

    /**
     * @return roleId
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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

    /**
     * 获取是否有效
     *
     * @return valid - 是否有效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 设置是否有效
     *
     * @param valid 是否有效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return isopr
     */
    public Boolean getIsopr() {
        return isopr;
    }

    /**
     * @param isopr
     */
    public void setIsopr(Boolean isopr) {
        this.isopr = isopr;
    }

    /**
     * @return permissionGroupId
     */
    public Integer getPermissiongroupid() {
        return permissiongroupid;
    }

    /**
     * @param permissiongroupid
     */
    public void setPermissiongroupid(Integer permissiongroupid) {
        this.permissiongroupid = permissiongroupid;
    }
}
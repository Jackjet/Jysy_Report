package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_oprole")
public class VmbOprole {
    @Id
    @Column(name = "oproleId")
    private Integer oproleid;

    /**
     * 角色（超级管理员，运营专员)
     */
    private Integer role;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 权限创建时间
     */
    private Date createtime;

    /**
     * 是否有效
     */
    private Boolean valid;

    /**
     * @return oproleId
     */
    public Integer getOproleid() {
        return oproleid;
    }

    /**
     * @param oproleid
     */
    public void setOproleid(Integer oproleid) {
        this.oproleid = oproleid;
    }

    /**
     * 获取角色（超级管理员，运营专员)
     *
     * @return role - 角色（超级管理员，运营专员)
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置角色（超级管理员，运营专员)
     *
     * @param role 角色（超级管理员，运营专员)
     */
    public void setRole(Integer role) {
        this.role = role;
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
     * 获取权限创建时间
     *
     * @return createtime - 权限创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置权限创建时间
     *
     * @param createtime 权限创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
}
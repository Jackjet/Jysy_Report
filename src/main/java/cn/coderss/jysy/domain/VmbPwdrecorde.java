package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_pwdrecorde")
public class VmbPwdrecorde {
    /**
     * 修改密码记录id
     */
    @Id
    private Integer pwdrecordeid;

    /**
     * 修改帐号
     */
    private Integer accountid;

    /**
     * 修改时间
     */
    @Column(name = "changed_time")
    private Date changedTime;

    private Integer enterpriseid;

    /**
     * 获取修改密码记录id
     *
     * @return pwdrecordeid - 修改密码记录id
     */
    public Integer getPwdrecordeid() {
        return pwdrecordeid;
    }

    /**
     * 设置修改密码记录id
     *
     * @param pwdrecordeid 修改密码记录id
     */
    public void setPwdrecordeid(Integer pwdrecordeid) {
        this.pwdrecordeid = pwdrecordeid;
    }

    /**
     * 获取修改帐号
     *
     * @return accountid - 修改帐号
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置修改帐号
     *
     * @param accountid 修改帐号
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取修改时间
     *
     * @return changed_time - 修改时间
     */
    public Date getChangedTime() {
        return changedTime;
    }

    /**
     * 设置修改时间
     *
     * @param changedTime 修改时间
     */
    public void setChangedTime(Date changedTime) {
        this.changedTime = changedTime;
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
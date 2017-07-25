package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "login_config")
public class LoginConfig {
    @Id
    private Integer collegeid;

    @Id
    private Integer enterpriseid;

    @Column(name = "verify_code")
    private Integer verifyCode;

    @Column(name = "remember_day")
    private Integer rememberDay;

    @Column(name = "forget_pwd_config")
    private Integer forgetPwdConfig;

    private Integer audit;

    @Column(name = "change_pwd_config")
    private Integer changePwdConfig;

    @Column(name = "change_pwd_every_day")
    private Integer changePwdEveryDay;

    @Column(name = "change_pwd_to_do_time")
    private Date changePwdToDoTime;

    @Column(name = "change_pwd_rate")
    private Integer changePwdRate;

    @Column(name = "login_test_count")
    private Integer loginTestCount;

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
     * @return verify_code
     */
    public Integer getVerifyCode() {
        return verifyCode;
    }

    /**
     * @param verifyCode
     */
    public void setVerifyCode(Integer verifyCode) {
        this.verifyCode = verifyCode;
    }

    /**
     * @return remember_day
     */
    public Integer getRememberDay() {
        return rememberDay;
    }

    /**
     * @param rememberDay
     */
    public void setRememberDay(Integer rememberDay) {
        this.rememberDay = rememberDay;
    }

    /**
     * @return forget_pwd_config
     */
    public Integer getForgetPwdConfig() {
        return forgetPwdConfig;
    }

    /**
     * @param forgetPwdConfig
     */
    public void setForgetPwdConfig(Integer forgetPwdConfig) {
        this.forgetPwdConfig = forgetPwdConfig;
    }

    /**
     * @return audit
     */
    public Integer getAudit() {
        return audit;
    }

    /**
     * @param audit
     */
    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    /**
     * @return change_pwd_config
     */
    public Integer getChangePwdConfig() {
        return changePwdConfig;
    }

    /**
     * @param changePwdConfig
     */
    public void setChangePwdConfig(Integer changePwdConfig) {
        this.changePwdConfig = changePwdConfig;
    }

    /**
     * @return change_pwd_every_day
     */
    public Integer getChangePwdEveryDay() {
        return changePwdEveryDay;
    }

    /**
     * @param changePwdEveryDay
     */
    public void setChangePwdEveryDay(Integer changePwdEveryDay) {
        this.changePwdEveryDay = changePwdEveryDay;
    }

    /**
     * @return change_pwd_to_do_time
     */
    public Date getChangePwdToDoTime() {
        return changePwdToDoTime;
    }

    /**
     * @param changePwdToDoTime
     */
    public void setChangePwdToDoTime(Date changePwdToDoTime) {
        this.changePwdToDoTime = changePwdToDoTime;
    }

    /**
     * @return change_pwd_rate
     */
    public Integer getChangePwdRate() {
        return changePwdRate;
    }

    /**
     * @param changePwdRate
     */
    public void setChangePwdRate(Integer changePwdRate) {
        this.changePwdRate = changePwdRate;
    }

    /**
     * @return login_test_count
     */
    public Integer getLoginTestCount() {
        return loginTestCount;
    }

    /**
     * @param loginTestCount
     */
    public void setLoginTestCount(Integer loginTestCount) {
        this.loginTestCount = loginTestCount;
    }
}
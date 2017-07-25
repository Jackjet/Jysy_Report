package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_accountschedule")
public class VmbAccountschedule {
    @Id
    @Column(name = "accountscheduleId")
    private Integer accountscheduleid;

    @Column(name = "learningScheduleId")
    private Integer learningscheduleid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 签到时间
     */
    private Date checkintime;

    private Integer opr;

    /**
     * @return accountscheduleId
     */
    public Integer getAccountscheduleid() {
        return accountscheduleid;
    }

    /**
     * @param accountscheduleid
     */
    public void setAccountscheduleid(Integer accountscheduleid) {
        this.accountscheduleid = accountscheduleid;
    }

    /**
     * @return learningScheduleId
     */
    public Integer getLearningscheduleid() {
        return learningscheduleid;
    }

    /**
     * @param learningscheduleid
     */
    public void setLearningscheduleid(Integer learningscheduleid) {
        this.learningscheduleid = learningscheduleid;
    }

    /**
     * @return learningActivityId
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * @param learningactivityid
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
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
     * 获取签到时间
     *
     * @return checkintime - 签到时间
     */
    public Date getCheckintime() {
        return checkintime;
    }

    /**
     * 设置签到时间
     *
     * @param checkintime 签到时间
     */
    public void setCheckintime(Date checkintime) {
        this.checkintime = checkintime;
    }

    /**
     * @return opr
     */
    public Integer getOpr() {
        return opr;
    }

    /**
     * @param opr
     */
    public void setOpr(Integer opr) {
        this.opr = opr;
    }
}
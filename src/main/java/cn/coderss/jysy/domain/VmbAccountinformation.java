package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_accountinformation")
public class VmbAccountinformation {
    @Id
    @Column(name = "accountInformationId")
    private Integer accountinformationid;

    @Column(name = "learningInformationId")
    private Integer learninginformationid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 打开时间
     */
    @Column(name = "openTime")
    private Date opentime;

    private Integer duration;

    private Boolean overed;

    /**
     * 用来表示结束状态
     */
    private Integer end;

    /**
     * @return accountInformationId
     */
    public Integer getAccountinformationid() {
        return accountinformationid;
    }

    /**
     * @param accountinformationid
     */
    public void setAccountinformationid(Integer accountinformationid) {
        this.accountinformationid = accountinformationid;
    }

    /**
     * @return learningInformationId
     */
    public Integer getLearninginformationid() {
        return learninginformationid;
    }

    /**
     * @param learninginformationid
     */
    public void setLearninginformationid(Integer learninginformationid) {
        this.learninginformationid = learninginformationid;
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
     * 获取打开时间
     *
     * @return openTime - 打开时间
     */
    public Date getOpentime() {
        return opentime;
    }

    /**
     * 设置打开时间
     *
     * @param opentime 打开时间
     */
    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    /**
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return overed
     */
    public Boolean getOvered() {
        return overed;
    }

    /**
     * @param overed
     */
    public void setOvered(Boolean overed) {
        this.overed = overed;
    }

    /**
     * 获取用来表示结束状态
     *
     * @return end - 用来表示结束状态
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * 设置用来表示结束状态
     *
     * @param end 用来表示结束状态
     */
    public void setEnd(Integer end) {
        this.end = end;
    }
}
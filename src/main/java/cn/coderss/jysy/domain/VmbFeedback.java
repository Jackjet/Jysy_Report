package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_feedback")
public class VmbFeedback {
    @Id
    @Column(name = "feedbackId")
    private Integer feedbackid;

    @Column(name = "accountId")
    private Integer accountid;

    private Date feedbacktime;

    private String content;

    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * @return feedbackId
     */
    public Integer getFeedbackid() {
        return feedbackid;
    }

    /**
     * @param feedbackid
     */
    public void setFeedbackid(Integer feedbackid) {
        this.feedbackid = feedbackid;
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
     * @return feedbacktime
     */
    public Date getFeedbacktime() {
        return feedbacktime;
    }

    /**
     * @param feedbacktime
     */
    public void setFeedbacktime(Date feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
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
}
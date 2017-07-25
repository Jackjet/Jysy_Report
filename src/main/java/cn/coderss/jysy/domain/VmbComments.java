package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_comments")
public class VmbComments {
    @Id
    @Column(name = "commentsId")
    private Integer commentsid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 评论星级
     */
    private Integer starcount;

    /**
     * 评论内容
     */
    private String comments;

    /**
     * 评论时间
     */
    private Date commenttime;

    /**
     * 是否显示
     */
    private Boolean show;

    private Integer receiveid;

    private Integer collegeid;

    /**
     * @return commentsId
     */
    public Integer getCommentsid() {
        return commentsid;
    }

    /**
     * @param commentsid
     */
    public void setCommentsid(Integer commentsid) {
        this.commentsid = commentsid;
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
     * 获取评论星级
     *
     * @return starcount - 评论星级
     */
    public Integer getStarcount() {
        return starcount;
    }

    /**
     * 设置评论星级
     *
     * @param starcount 评论星级
     */
    public void setStarcount(Integer starcount) {
        this.starcount = starcount;
    }

    /**
     * 获取评论内容
     *
     * @return comments - 评论内容
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置评论内容
     *
     * @param comments 评论内容
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取评论时间
     *
     * @return commenttime - 评论时间
     */
    public Date getCommenttime() {
        return commenttime;
    }

    /**
     * 设置评论时间
     *
     * @param commenttime 评论时间
     */
    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    /**
     * 获取是否显示
     *
     * @return show - 是否显示
     */
    public Boolean getShow() {
        return show;
    }

    /**
     * 设置是否显示
     *
     * @param show 是否显示
     */
    public void setShow(Boolean show) {
        this.show = show;
    }

    /**
     * @return receiveid
     */
    public Integer getReceiveid() {
        return receiveid;
    }

    /**
     * @param receiveid
     */
    public void setReceiveid(Integer receiveid) {
        this.receiveid = receiveid;
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
}
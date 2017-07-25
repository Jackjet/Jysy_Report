package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bcm_points_temp")
public class BcmPointsTemp {
    @Id
    private Integer pointid;

    private Integer accountid;

    /**
     * 课程
     */
    private Integer course;

    /**
     * 微系列章节
     */
    private Integer series;

    /**
     * 考试
     */
    private Integer exam;

    /**
     * 资料
     */
    private Integer info;

    /**
     * 发帖
     */
    private Integer post;

    /**
     * 回复
     */
    private Integer reply;

    /**
     * 线下导入
     */
    private Integer offline;

    private Integer activityid;

    private Date createtime;

    /**
     * @return pointid
     */
    public Integer getPointid() {
        return pointid;
    }

    /**
     * @param pointid
     */
    public void setPointid(Integer pointid) {
        this.pointid = pointid;
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
     * 获取课程
     *
     * @return course - 课程
     */
    public Integer getCourse() {
        return course;
    }

    /**
     * 设置课程
     *
     * @param course 课程
     */
    public void setCourse(Integer course) {
        this.course = course;
    }

    /**
     * 获取微系列章节
     *
     * @return series - 微系列章节
     */
    public Integer getSeries() {
        return series;
    }

    /**
     * 设置微系列章节
     *
     * @param series 微系列章节
     */
    public void setSeries(Integer series) {
        this.series = series;
    }

    /**
     * 获取考试
     *
     * @return exam - 考试
     */
    public Integer getExam() {
        return exam;
    }

    /**
     * 设置考试
     *
     * @param exam 考试
     */
    public void setExam(Integer exam) {
        this.exam = exam;
    }

    /**
     * 获取资料
     *
     * @return info - 资料
     */
    public Integer getInfo() {
        return info;
    }

    /**
     * 设置资料
     *
     * @param info 资料
     */
    public void setInfo(Integer info) {
        this.info = info;
    }

    /**
     * 获取发帖
     *
     * @return post - 发帖
     */
    public Integer getPost() {
        return post;
    }

    /**
     * 设置发帖
     *
     * @param post 发帖
     */
    public void setPost(Integer post) {
        this.post = post;
    }

    /**
     * 获取回复
     *
     * @return reply - 回复
     */
    public Integer getReply() {
        return reply;
    }

    /**
     * 设置回复
     *
     * @param reply 回复
     */
    public void setReply(Integer reply) {
        this.reply = reply;
    }

    /**
     * 获取线下导入
     *
     * @return offline - 线下导入
     */
    public Integer getOffline() {
        return offline;
    }

    /**
     * 设置线下导入
     *
     * @param offline 线下导入
     */
    public void setOffline(Integer offline) {
        this.offline = offline;
    }

    /**
     * @return activityid
     */
    public Integer getActivityid() {
        return activityid;
    }

    /**
     * @param activityid
     */
    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
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
}
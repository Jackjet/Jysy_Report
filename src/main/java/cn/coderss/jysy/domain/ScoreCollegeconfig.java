package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "score_collegeconfig")
public class ScoreCollegeconfig {
    @Id
    private Integer configid;

    private Integer course;

    private Integer exam;

    private Integer info;

    private Integer post;

    private Integer reply;

    private Integer collegeid;

    private Integer activityid;

    /**
     * @return configid
     */
    public Integer getConfigid() {
        return configid;
    }

    /**
     * @param configid
     */
    public void setConfigid(Integer configid) {
        this.configid = configid;
    }

    /**
     * @return course
     */
    public Integer getCourse() {
        return course;
    }

    /**
     * @param course
     */
    public void setCourse(Integer course) {
        this.course = course;
    }

    /**
     * @return exam
     */
    public Integer getExam() {
        return exam;
    }

    /**
     * @param exam
     */
    public void setExam(Integer exam) {
        this.exam = exam;
    }

    /**
     * @return info
     */
    public Integer getInfo() {
        return info;
    }

    /**
     * @param info
     */
    public void setInfo(Integer info) {
        this.info = info;
    }

    /**
     * @return post
     */
    public Integer getPost() {
        return post;
    }

    /**
     * @param post
     */
    public void setPost(Integer post) {
        this.post = post;
    }

    /**
     * @return reply
     */
    public Integer getReply() {
        return reply;
    }

    /**
     * @param reply
     */
    public void setReply(Integer reply) {
        this.reply = reply;
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
}
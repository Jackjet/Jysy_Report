package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_scormdesc")
public class VmbScormdesc {
    /**
     * 记录scorm的一些额外信息
     */
    @Id
    private Integer scormdescid;

    private Integer accountid;

    private Float score;

    /**
     * 记录accountid对这门课的学习情况
     */
    @Column(name = "lesson_status")
    private String lessonStatus;

    private Integer scormid;

    /**
     * 此次课件打开时间
     */
    private Date opentime;

    private Integer learningactivityid;

    /**
     * 获取记录scorm的一些额外信息
     *
     * @return scormdescid - 记录scorm的一些额外信息
     */
    public Integer getScormdescid() {
        return scormdescid;
    }

    /**
     * 设置记录scorm的一些额外信息
     *
     * @param scormdescid 记录scorm的一些额外信息
     */
    public void setScormdescid(Integer scormdescid) {
        this.scormdescid = scormdescid;
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
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 获取记录accountid对这门课的学习情况
     *
     * @return lesson_status - 记录accountid对这门课的学习情况
     */
    public String getLessonStatus() {
        return lessonStatus;
    }

    /**
     * 设置记录accountid对这门课的学习情况
     *
     * @param lessonStatus 记录accountid对这门课的学习情况
     */
    public void setLessonStatus(String lessonStatus) {
        this.lessonStatus = lessonStatus;
    }

    /**
     * @return scormid
     */
    public Integer getScormid() {
        return scormid;
    }

    /**
     * @param scormid
     */
    public void setScormid(Integer scormid) {
        this.scormid = scormid;
    }

    /**
     * 获取此次课件打开时间
     *
     * @return opentime - 此次课件打开时间
     */
    public Date getOpentime() {
        return opentime;
    }

    /**
     * 设置此次课件打开时间
     *
     * @param opentime 此次课件打开时间
     */
    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    /**
     * @return learningactivityid
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
}
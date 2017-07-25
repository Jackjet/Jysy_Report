package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_learningschedule")
public class VmbLearningschedule {
    @Id
    @Column(name = "learningScheduleId")
    private Integer learningscheduleid;

    @Column(name = "trainingProgramId")
    private Integer trainingprogramid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    private Date starttime;

    private Date endtime;

    private String title;

    private Integer duration;

    /**
     * 教学方式（考试、调研、课程）
     */
    @Column(name = "teachingMethod")
    private Integer teachingmethod;

    @Column(name = "relationshipId")
    private Integer relationshipid;

    private String description;

    private Boolean mustcheckin;

    private Integer orginalid;

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
     * @return trainingProgramId
     */
    public Integer getTrainingprogramid() {
        return trainingprogramid;
    }

    /**
     * @param trainingprogramid
     */
    public void setTrainingprogramid(Integer trainingprogramid) {
        this.trainingprogramid = trainingprogramid;
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
     * @return starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * @param starttime
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * @return endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取教学方式（考试、调研、课程）
     *
     * @return teachingMethod - 教学方式（考试、调研、课程）
     */
    public Integer getTeachingmethod() {
        return teachingmethod;
    }

    /**
     * 设置教学方式（考试、调研、课程）
     *
     * @param teachingmethod 教学方式（考试、调研、课程）
     */
    public void setTeachingmethod(Integer teachingmethod) {
        this.teachingmethod = teachingmethod;
    }

    /**
     * @return relationshipId
     */
    public Integer getRelationshipid() {
        return relationshipid;
    }

    /**
     * @param relationshipid
     */
    public void setRelationshipid(Integer relationshipid) {
        this.relationshipid = relationshipid;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return mustcheckin
     */
    public Boolean getMustcheckin() {
        return mustcheckin;
    }

    /**
     * @param mustcheckin
     */
    public void setMustcheckin(Boolean mustcheckin) {
        this.mustcheckin = mustcheckin;
    }

    /**
     * @return orginalid
     */
    public Integer getOrginalid() {
        return orginalid;
    }

    /**
     * @param orginalid
     */
    public void setOrginalid(Integer orginalid) {
        this.orginalid = orginalid;
    }
}
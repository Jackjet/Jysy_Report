package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_promotionactivity")
public class VmbPromotionactivity {
    @Id
    private Integer activitycourseid;

    @Column(name = "activityId")
    private Integer activityid;

    @Column(name = "courseId")
    private Integer courseid;

    /**
     * @return activitycourseid
     */
    public Integer getActivitycourseid() {
        return activitycourseid;
    }

    /**
     * @param activitycourseid
     */
    public void setActivitycourseid(Integer activitycourseid) {
        this.activitycourseid = activitycourseid;
    }

    /**
     * @return activityId
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
     * @return courseId
     */
    public Integer getCourseid() {
        return courseid;
    }

    /**
     * @param courseid
     */
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_learningteacher")
public class VmbLearningteacher {
    @Id
    @Column(name = "learningTeacherId")
    private Integer learningteacherid;

    @Column(name = "teacherId")
    private Integer teacherid;

    @Column(name = "learningScheduleId")
    private Integer learningscheduleid;

    /**
     * @return learningTeacherId
     */
    public Integer getLearningteacherid() {
        return learningteacherid;
    }

    /**
     * @param learningteacherid
     */
    public void setLearningteacherid(Integer learningteacherid) {
        this.learningteacherid = learningteacherid;
    }

    /**
     * @return teacherId
     */
    public Integer getTeacherid() {
        return teacherid;
    }

    /**
     * @param teacherid
     */
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
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
}
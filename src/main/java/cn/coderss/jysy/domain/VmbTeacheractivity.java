package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_teacheractivity")
public class VmbTeacheractivity {
    @Id
    @Column(name = "teacherActivityId")
    private Integer teacheractivityid;

    /**
     * 学习活动Id
     */
    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    /**
     * 讲师Id
     */
    @Column(name = "teacherId")
    private Integer teacherid;

    /**
     * @return teacherActivityId
     */
    public Integer getTeacheractivityid() {
        return teacheractivityid;
    }

    /**
     * @param teacheractivityid
     */
    public void setTeacheractivityid(Integer teacheractivityid) {
        this.teacheractivityid = teacheractivityid;
    }

    /**
     * 获取学习活动Id
     *
     * @return learningActivityId - 学习活动Id
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置学习活动Id
     *
     * @param learningactivityid 学习活动Id
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取讲师Id
     *
     * @return teacherId - 讲师Id
     */
    public Integer getTeacherid() {
        return teacherid;
    }

    /**
     * 设置讲师Id
     *
     * @param teacherid 讲师Id
     */
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }
}
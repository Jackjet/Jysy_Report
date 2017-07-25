package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_prerequisite")
public class VmbPrerequisite {
    /**
     * 先决条件id
     */
    @Id
    private Integer prerequisiteid;

    /**
     * 任务的先决条件任务id
     */
    @Column(name = "prerequisite_issueid")
    private Integer prerequisiteIssueid;

    /**
     * 学习计划id
     */
    private Integer learningactivityid;

    /**
     * 任务id
     */
    private Integer issueid;

    /**
     * 获取先决条件id
     *
     * @return prerequisiteid - 先决条件id
     */
    public Integer getPrerequisiteid() {
        return prerequisiteid;
    }

    /**
     * 设置先决条件id
     *
     * @param prerequisiteid 先决条件id
     */
    public void setPrerequisiteid(Integer prerequisiteid) {
        this.prerequisiteid = prerequisiteid;
    }

    /**
     * 获取任务的先决条件任务id
     *
     * @return prerequisite_issueid - 任务的先决条件任务id
     */
    public Integer getPrerequisiteIssueid() {
        return prerequisiteIssueid;
    }

    /**
     * 设置任务的先决条件任务id
     *
     * @param prerequisiteIssueid 任务的先决条件任务id
     */
    public void setPrerequisiteIssueid(Integer prerequisiteIssueid) {
        this.prerequisiteIssueid = prerequisiteIssueid;
    }

    /**
     * 获取学习计划id
     *
     * @return learningactivityid - 学习计划id
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置学习计划id
     *
     * @param learningactivityid 学习计划id
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取任务id
     *
     * @return issueid - 任务id
     */
    public Integer getIssueid() {
        return issueid;
    }

    /**
     * 设置任务id
     *
     * @param issueid 任务id
     */
    public void setIssueid(Integer issueid) {
        this.issueid = issueid;
    }
}
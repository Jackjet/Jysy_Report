package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_distribactivity")
public class VmbDistribactivity {
    @Id
    @Column(name = "distribActivityId")
    private Integer distribactivityid;

    @Column(name = "solutionId")
    private Integer solutionid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "orgdistribId")
    private Integer orgdistribid;

    @Column(name = "ownerId")
    private Integer ownerid;

    private Integer orderindex;

    private Date createtime;

    private Integer activitycollegeid;

    private Integer activityenterpriseid;

    /**
     * @return distribActivityId
     */
    public Integer getDistribactivityid() {
        return distribactivityid;
    }

    /**
     * @param distribactivityid
     */
    public void setDistribactivityid(Integer distribactivityid) {
        this.distribactivityid = distribactivityid;
    }

    /**
     * @return solutionId
     */
    public Integer getSolutionid() {
        return solutionid;
    }

    /**
     * @param solutionid
     */
    public void setSolutionid(Integer solutionid) {
        this.solutionid = solutionid;
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
     * @return orgdistribId
     */
    public Integer getOrgdistribid() {
        return orgdistribid;
    }

    /**
     * @param orgdistribid
     */
    public void setOrgdistribid(Integer orgdistribid) {
        this.orgdistribid = orgdistribid;
    }

    /**
     * @return ownerId
     */
    public Integer getOwnerid() {
        return ownerid;
    }

    /**
     * @param ownerid
     */
    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    /**
     * @return orderindex
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
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

    /**
     * @return activitycollegeid
     */
    public Integer getActivitycollegeid() {
        return activitycollegeid;
    }

    /**
     * @param activitycollegeid
     */
    public void setActivitycollegeid(Integer activitycollegeid) {
        this.activitycollegeid = activitycollegeid;
    }

    /**
     * @return activityenterpriseid
     */
    public Integer getActivityenterpriseid() {
        return activityenterpriseid;
    }

    /**
     * @param activityenterpriseid
     */
    public void setActivityenterpriseid(Integer activityenterpriseid) {
        this.activityenterpriseid = activityenterpriseid;
    }
}
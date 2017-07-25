package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_activityorgdistrib")
public class VmbActivityorgdistrib {
    @Id
    @Column(name = "orgDistribId")
    private Integer orgdistribid;

    /**
     * 分配数量
     */
    @Column(name = "distribCount")
    private Integer distribcount;

    /**
     * 学习活动归属权
     */
    @Column(name = "ownerId")
    private Integer ownerid;

    /**
     * 学习活动Id
     */
    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    /**
     * 是否拥有无限分配数
     */
    private Boolean infinite;

    /**
     * 课程分配的目标学院
     */
    @Column(name = "destCollegeId")
    private Integer destcollegeid;

    /**
     * 分配方案
     */
    @Column(name = "solutionId")
    private Integer solutionid;

    /**
     * 是否有效
     */
    private Boolean valid;

    private Boolean recommend;

    private Boolean public;

    private Integer orderindex;

    private Date createtime;

    private Integer activitycollegeid;

    private Integer activityenterpriseid;

    private Integer tempid;

    /**
     * @return orgDistribId
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
     * 获取分配数量
     *
     * @return distribCount - 分配数量
     */
    public Integer getDistribcount() {
        return distribcount;
    }

    /**
     * 设置分配数量
     *
     * @param distribcount 分配数量
     */
    public void setDistribcount(Integer distribcount) {
        this.distribcount = distribcount;
    }

    /**
     * 获取学习活动归属权
     *
     * @return ownerId - 学习活动归属权
     */
    public Integer getOwnerid() {
        return ownerid;
    }

    /**
     * 设置学习活动归属权
     *
     * @param ownerid 学习活动归属权
     */
    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
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
     * 获取是否拥有无限分配数
     *
     * @return infinite - 是否拥有无限分配数
     */
    public Boolean getInfinite() {
        return infinite;
    }

    /**
     * 设置是否拥有无限分配数
     *
     * @param infinite 是否拥有无限分配数
     */
    public void setInfinite(Boolean infinite) {
        this.infinite = infinite;
    }

    /**
     * 获取课程分配的目标学院
     *
     * @return destCollegeId - 课程分配的目标学院
     */
    public Integer getDestcollegeid() {
        return destcollegeid;
    }

    /**
     * 设置课程分配的目标学院
     *
     * @param destcollegeid 课程分配的目标学院
     */
    public void setDestcollegeid(Integer destcollegeid) {
        this.destcollegeid = destcollegeid;
    }

    /**
     * 获取分配方案
     *
     * @return solutionId - 分配方案
     */
    public Integer getSolutionid() {
        return solutionid;
    }

    /**
     * 设置分配方案
     *
     * @param solutionid 分配方案
     */
    public void setSolutionid(Integer solutionid) {
        this.solutionid = solutionid;
    }

    /**
     * 获取是否有效
     *
     * @return valid - 是否有效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 设置是否有效
     *
     * @param valid 是否有效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * @return recommend
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * @return public
     */
    public Boolean getPublic() {
        return public;
    }

    /**
     * @param public
     */
    public void setPublic(Boolean public) {
        this.public = public;
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

    /**
     * @return tempid
     */
    public Integer getTempid() {
        return tempid;
    }

    /**
     * @param tempid
     */
    public void setTempid(Integer tempid) {
        this.tempid = tempid;
    }
}
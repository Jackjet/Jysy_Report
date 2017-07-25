package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_activitymemberdestrib")
public class VmbActivitymemberdestrib {
    @Id
    @Column(name = "memberDestribId")
    private Integer memberdestribid;

    @Column(name = "orgDistributId")
    private Integer orgdistributid;

    /**
     * 分配的目标成员
     */
    @Column(name = "destMemberId")
    private Integer destmemberid;

    /**
     * 分配记录
     */
    @Column(name = "solutionId")
    private Integer solutionid;

    /**
     * 被分配的学习活动
     */
    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    /**
     * 该次分配对应的学习活动所有者
     */
    @Column(name = "ownerId")
    private Integer ownerid;

    /**
     * 是否必修
     */
    private Boolean required;

    /**
     * 是否有效
     */
    private Boolean valid;

    private Boolean recommend;

    private Date createtime;

    private Integer accountid;

    private Integer activitycollegeid;

    private Integer activityenterpriseid;

    /**
     * @return memberDestribId
     */
    public Integer getMemberdestribid() {
        return memberdestribid;
    }

    /**
     * @param memberdestribid
     */
    public void setMemberdestribid(Integer memberdestribid) {
        this.memberdestribid = memberdestribid;
    }

    /**
     * @return orgDistributId
     */
    public Integer getOrgdistributid() {
        return orgdistributid;
    }

    /**
     * @param orgdistributid
     */
    public void setOrgdistributid(Integer orgdistributid) {
        this.orgdistributid = orgdistributid;
    }

    /**
     * 获取分配的目标成员
     *
     * @return destMemberId - 分配的目标成员
     */
    public Integer getDestmemberid() {
        return destmemberid;
    }

    /**
     * 设置分配的目标成员
     *
     * @param destmemberid 分配的目标成员
     */
    public void setDestmemberid(Integer destmemberid) {
        this.destmemberid = destmemberid;
    }

    /**
     * 获取分配记录
     *
     * @return solutionId - 分配记录
     */
    public Integer getSolutionid() {
        return solutionid;
    }

    /**
     * 设置分配记录
     *
     * @param solutionid 分配记录
     */
    public void setSolutionid(Integer solutionid) {
        this.solutionid = solutionid;
    }

    /**
     * 获取被分配的学习活动
     *
     * @return learningActivityId - 被分配的学习活动
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置被分配的学习活动
     *
     * @param learningactivityid 被分配的学习活动
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取该次分配对应的学习活动所有者
     *
     * @return ownerId - 该次分配对应的学习活动所有者
     */
    public Integer getOwnerid() {
        return ownerid;
    }

    /**
     * 设置该次分配对应的学习活动所有者
     *
     * @param ownerid 该次分配对应的学习活动所有者
     */
    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    /**
     * 获取是否必修
     *
     * @return required - 是否必修
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * 设置是否必修
     *
     * @param required 是否必修
     */
    public void setRequired(Boolean required) {
        this.required = required;
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
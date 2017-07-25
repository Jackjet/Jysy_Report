package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_issueactivity")
public class VmbIssueactivity {
    /**
     * 任务活动id
     */
    @Id
    private Integer issueactivityid;

    /**
     * 学习计划id
     */
    private Integer learningactivityid;

    /**
     * 任务关联活动的排序
     */
    private Integer orderindex;

    /**
     * 任务关联活动名称
     */
    private String name;

    /**
     * 关联的活动id
     */
    @Column(name = "rel_activityid")
    private Integer relActivityid;

    /**
     * 关联活动的类型
     */
    @Column(name = "rel_acttype")
    private Integer relActtype;

    /**
     * 活动对应的任务id
     */
    private Integer issueid;

    /**
     * 选课学员id
     */
    private Integer accountid;

    private Integer valid;

    /**
     * 获取任务活动id
     *
     * @return issueactivityid - 任务活动id
     */
    public Integer getIssueactivityid() {
        return issueactivityid;
    }

    /**
     * 设置任务活动id
     *
     * @param issueactivityid 任务活动id
     */
    public void setIssueactivityid(Integer issueactivityid) {
        this.issueactivityid = issueactivityid;
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
     * 获取任务关联活动的排序
     *
     * @return orderindex - 任务关联活动的排序
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * 设置任务关联活动的排序
     *
     * @param orderindex 任务关联活动的排序
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * 获取任务关联活动名称
     *
     * @return name - 任务关联活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置任务关联活动名称
     *
     * @param name 任务关联活动名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取关联的活动id
     *
     * @return rel_activityid - 关联的活动id
     */
    public Integer getRelActivityid() {
        return relActivityid;
    }

    /**
     * 设置关联的活动id
     *
     * @param relActivityid 关联的活动id
     */
    public void setRelActivityid(Integer relActivityid) {
        this.relActivityid = relActivityid;
    }

    /**
     * 获取关联活动的类型
     *
     * @return rel_acttype - 关联活动的类型
     */
    public Integer getRelActtype() {
        return relActtype;
    }

    /**
     * 设置关联活动的类型
     *
     * @param relActtype 关联活动的类型
     */
    public void setRelActtype(Integer relActtype) {
        this.relActtype = relActtype;
    }

    /**
     * 获取活动对应的任务id
     *
     * @return issueid - 活动对应的任务id
     */
    public Integer getIssueid() {
        return issueid;
    }

    /**
     * 设置活动对应的任务id
     *
     * @param issueid 活动对应的任务id
     */
    public void setIssueid(Integer issueid) {
        this.issueid = issueid;
    }

    /**
     * 获取选课学员id
     *
     * @return accountid - 选课学员id
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置选课学员id
     *
     * @param accountid 选课学员id
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * @return valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
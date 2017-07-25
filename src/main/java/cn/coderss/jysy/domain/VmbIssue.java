package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_issue")
public class VmbIssue {
    /**
     * 任务id
     */
    @Id
    private Integer issueid;

    /**
     * 任务编码
     */
    private String code;

    /**
     * 任务排序
     */
    private Integer orderindex;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 父级任务id
     */
    @Column(name = "parent_issueid")
    private Integer parentIssueid;

    /**
     * 关联的学习计划id
     */
    private Integer learningactivityid;

    /**
     * 必修数量
     */
    @Column(name = "require_count")
    private Integer requireCount;

    /**
     * 任务类型
     */
    @Column(name = "issue_type")
    private Integer issueType;

    /**
     * 最低学时
     */
    @Column(name = "min_period")
    private Float minPeriod;

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

    /**
     * 获取任务编码
     *
     * @return code - 任务编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置任务编码
     *
     * @param code 任务编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取任务排序
     *
     * @return orderindex - 任务排序
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * 设置任务排序
     *
     * @param orderindex 任务排序
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * 获取任务名称
     *
     * @return name - 任务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置任务名称
     *
     * @param name 任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父级任务id
     *
     * @return parent_issueid - 父级任务id
     */
    public Integer getParentIssueid() {
        return parentIssueid;
    }

    /**
     * 设置父级任务id
     *
     * @param parentIssueid 父级任务id
     */
    public void setParentIssueid(Integer parentIssueid) {
        this.parentIssueid = parentIssueid;
    }

    /**
     * 获取关联的学习计划id
     *
     * @return learningactivityid - 关联的学习计划id
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置关联的学习计划id
     *
     * @param learningactivityid 关联的学习计划id
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取必修数量
     *
     * @return require_count - 必修数量
     */
    public Integer getRequireCount() {
        return requireCount;
    }

    /**
     * 设置必修数量
     *
     * @param requireCount 必修数量
     */
    public void setRequireCount(Integer requireCount) {
        this.requireCount = requireCount;
    }

    /**
     * 获取任务类型
     *
     * @return issue_type - 任务类型
     */
    public Integer getIssueType() {
        return issueType;
    }

    /**
     * 设置任务类型
     *
     * @param issueType 任务类型
     */
    public void setIssueType(Integer issueType) {
        this.issueType = issueType;
    }

    /**
     * 获取最低学时
     *
     * @return min_period - 最低学时
     */
    public Float getMinPeriod() {
        return minPeriod;
    }

    /**
     * 设置最低学时
     *
     * @param minPeriod 最低学时
     */
    public void setMinPeriod(Float minPeriod) {
        this.minPeriod = minPeriod;
    }
}
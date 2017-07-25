package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_question")
public class VmbQuestion {
    @Id
    @Column(name = "questionId")
    private Integer questionid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * 问题标题
     */
    private String title;

    /**
     * 问题描述
     */
    private String description;

    /**
     * 问题类型（选择题，简答题）
     */
    private Integer quetype;

    /**
     * 问题分类（调研、考试）
     */
    private Integer catalog;

    /**
     * 是否允许多选
     */
    private Boolean multi;

    private String code;

    /**
     * @return questionId
     */
    public Integer getQuestionid() {
        return questionid;
    }

    /**
     * @param questionid
     */
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    /**
     * @return enterpriseId
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * @return collegeId
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * @param collegeid
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * 获取问题标题
     *
     * @return title - 问题标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置问题标题
     *
     * @param title 问题标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取问题描述
     *
     * @return description - 问题描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置问题描述
     *
     * @param description 问题描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取问题类型（选择题，简答题）
     *
     * @return quetype - 问题类型（选择题，简答题）
     */
    public Integer getQuetype() {
        return quetype;
    }

    /**
     * 设置问题类型（选择题，简答题）
     *
     * @param quetype 问题类型（选择题，简答题）
     */
    public void setQuetype(Integer quetype) {
        this.quetype = quetype;
    }

    /**
     * 获取问题分类（调研、考试）
     *
     * @return catalog - 问题分类（调研、考试）
     */
    public Integer getCatalog() {
        return catalog;
    }

    /**
     * 设置问题分类（调研、考试）
     *
     * @param catalog 问题分类（调研、考试）
     */
    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    /**
     * 获取是否允许多选
     *
     * @return multi - 是否允许多选
     */
    public Boolean getMulti() {
        return multi;
    }

    /**
     * 设置是否允许多选
     *
     * @param multi 是否允许多选
     */
    public void setMulti(Boolean multi) {
        this.multi = multi;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_memberexam")
public class VmbMemberexam {
    @Id
    @Column(name = "memberExamId")
    private Integer memberexamid;

    @Column(name = "examinationId")
    private Integer examinationid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 是否推荐
     */
    private Boolean recommend;

    /**
     * 是否必考
     */
    private Boolean required;

    /**
     * 排序号
     */
    private Integer orderindex;

    /**
     * @return memberExamId
     */
    public Integer getMemberexamid() {
        return memberexamid;
    }

    /**
     * @param memberexamid
     */
    public void setMemberexamid(Integer memberexamid) {
        this.memberexamid = memberexamid;
    }

    /**
     * @return examinationId
     */
    public Integer getExaminationid() {
        return examinationid;
    }

    /**
     * @param examinationid
     */
    public void setExaminationid(Integer examinationid) {
        this.examinationid = examinationid;
    }

    /**
     * @return accountId
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
     * 获取是否推荐
     *
     * @return recommend - 是否推荐
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * 设置是否推荐
     *
     * @param recommend 是否推荐
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * 获取是否必考
     *
     * @return required - 是否必考
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * 设置是否必考
     *
     * @param required 是否必考
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * 获取排序号
     *
     * @return orderindex - 排序号
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * 设置排序号
     *
     * @param orderindex 排序号
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }
}
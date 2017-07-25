package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_memberresearch")
public class VmbMemberresearch {
    @Id
    @Column(name = "memberResearchId")
    private Integer memberresearchid;

    @Column(name = "researchId")
    private Integer researchid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 是否推荐
     */
    private Boolean recommend;

    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * @return memberResearchId
     */
    public Integer getMemberresearchid() {
        return memberresearchid;
    }

    /**
     * @param memberresearchid
     */
    public void setMemberresearchid(Integer memberresearchid) {
        this.memberresearchid = memberresearchid;
    }

    /**
     * @return researchId
     */
    public Integer getResearchid() {
        return researchid;
    }

    /**
     * @param researchid
     */
    public void setResearchid(Integer researchid) {
        this.researchid = researchid;
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
     * 获取是否必填
     *
     * @return required - 是否必填
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * 设置是否必填
     *
     * @param required 是否必填
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }
}
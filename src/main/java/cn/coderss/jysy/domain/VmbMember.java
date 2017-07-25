package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_member")
public class VmbMember {
    @Id
    @Column(name = "memberId")
    private Integer memberid;

    /**
     * 所属机构
     */
    @Column(name = "ordId")
    private Integer ordid;

    /**
     * 对应账户
     */
    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 所属企业
     */
    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 是否有效
     */
    private Integer activities;

    /**
     * 职务
     */
    private String post;

    /**
     * 角色状态（活动，待激活，已禁用）
     */
    private Integer states;

    /**
     * 企业成员类型
     */
    private Integer membertype;

    /**
     * 用户工号
     */
    private String workno;

    private Date createtime;

    @Column(name = "org_custom_name")
    private String orgCustomName;

    @Column(name = "org_second_id")
    private Integer orgSecondId;

    private String position;

    /**
     * @return memberId
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * @param memberid
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * 获取所属机构
     *
     * @return ordId - 所属机构
     */
    public Integer getOrdid() {
        return ordid;
    }

    /**
     * 设置所属机构
     *
     * @param ordid 所属机构
     */
    public void setOrdid(Integer ordid) {
        this.ordid = ordid;
    }

    /**
     * 获取对应账户
     *
     * @return accountId - 对应账户
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置对应账户
     *
     * @param accountid 对应账户
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取所属企业
     *
     * @return enterpriseId - 所属企业
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * 设置所属企业
     *
     * @param enterpriseid 所属企业
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * 获取是否有效
     *
     * @return activities - 是否有效
     */
    public Integer getActivities() {
        return activities;
    }

    /**
     * 设置是否有效
     *
     * @param activities 是否有效
     */
    public void setActivities(Integer activities) {
        this.activities = activities;
    }

    /**
     * 获取职务
     *
     * @return post - 职务
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置职务
     *
     * @param post 职务
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取角色状态（活动，待激活，已禁用）
     *
     * @return states - 角色状态（活动，待激活，已禁用）
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置角色状态（活动，待激活，已禁用）
     *
     * @param states 角色状态（活动，待激活，已禁用）
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * 获取企业成员类型
     *
     * @return membertype - 企业成员类型
     */
    public Integer getMembertype() {
        return membertype;
    }

    /**
     * 设置企业成员类型
     *
     * @param membertype 企业成员类型
     */
    public void setMembertype(Integer membertype) {
        this.membertype = membertype;
    }

    /**
     * 获取用户工号
     *
     * @return workno - 用户工号
     */
    public String getWorkno() {
        return workno;
    }

    /**
     * 设置用户工号
     *
     * @param workno 用户工号
     */
    public void setWorkno(String workno) {
        this.workno = workno;
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
     * @return org_custom_name
     */
    public String getOrgCustomName() {
        return orgCustomName;
    }

    /**
     * @param orgCustomName
     */
    public void setOrgCustomName(String orgCustomName) {
        this.orgCustomName = orgCustomName;
    }

    /**
     * @return org_second_id
     */
    public Integer getOrgSecondId() {
        return orgSecondId;
    }

    /**
     * @param orgSecondId
     */
    public void setOrgSecondId(Integer orgSecondId) {
        this.orgSecondId = orgSecondId;
    }

    /**
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_learninginfopack")
public class VmbLearninginfopack {
    @Id
    @Column(name = "learningInfoPackId")
    private Integer learninginfopackid;

    /**
     * 学习计划Id
     */
    @Column(name = "learningScheduleId")
    private Integer learningscheduleid;

    /**
     * 所属教学计划资料包
     */
    @Column(name = "infoPackId")
    private Integer infopackid;

    /**
     * 资料包名称
     */
    private String name;

    /**
     * 排序号
     */
    @Column(name = "orderIndex")
    private Integer orderindex;

    /**
     * LOGO Url
     */
    @Column(name = "logoUrl")
    private String logourl;

    /**
     * 所占格子数量
     */
    @Column(name = "cellCount")
    private Integer cellcount;

    private Integer orginalid;

    @Column(name = "Description")
    private String description;

    private Integer learningactivityid;

    /**
     * @return learningInfoPackId
     */
    public Integer getLearninginfopackid() {
        return learninginfopackid;
    }

    /**
     * @param learninginfopackid
     */
    public void setLearninginfopackid(Integer learninginfopackid) {
        this.learninginfopackid = learninginfopackid;
    }

    /**
     * 获取学习计划Id
     *
     * @return learningScheduleId - 学习计划Id
     */
    public Integer getLearningscheduleid() {
        return learningscheduleid;
    }

    /**
     * 设置学习计划Id
     *
     * @param learningscheduleid 学习计划Id
     */
    public void setLearningscheduleid(Integer learningscheduleid) {
        this.learningscheduleid = learningscheduleid;
    }

    /**
     * 获取所属教学计划资料包
     *
     * @return infoPackId - 所属教学计划资料包
     */
    public Integer getInfopackid() {
        return infopackid;
    }

    /**
     * 设置所属教学计划资料包
     *
     * @param infopackid 所属教学计划资料包
     */
    public void setInfopackid(Integer infopackid) {
        this.infopackid = infopackid;
    }

    /**
     * 获取资料包名称
     *
     * @return name - 资料包名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资料包名称
     *
     * @param name 资料包名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序号
     *
     * @return orderIndex - 排序号
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

    /**
     * 获取LOGO Url
     *
     * @return logoUrl - LOGO Url
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * 设置LOGO Url
     *
     * @param logourl LOGO Url
     */
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    /**
     * 获取所占格子数量
     *
     * @return cellCount - 所占格子数量
     */
    public Integer getCellcount() {
        return cellcount;
    }

    /**
     * 设置所占格子数量
     *
     * @param cellcount 所占格子数量
     */
    public void setCellcount(Integer cellcount) {
        this.cellcount = cellcount;
    }

    /**
     * @return orginalid
     */
    public Integer getOrginalid() {
        return orginalid;
    }

    /**
     * @param orginalid
     */
    public void setOrginalid(Integer orginalid) {
        this.orginalid = orginalid;
    }

    /**
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return learningactivityid
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
}
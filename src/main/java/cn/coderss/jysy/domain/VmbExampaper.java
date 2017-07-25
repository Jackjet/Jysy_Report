package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_exampaper")
public class VmbExampaper {
    @Id
    @Column(name = "paperId")
    private Integer paperid;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 试卷标题
     */
    private String title;

    /**
     * 试卷状态（未上架、已上架、已下架）
     */
    private Integer states;

    /**
     * 试卷简介
     */
    private String description;

    /**
     * 是否随机出题
     */
    private Boolean dynamic;

    private Integer orderindextype;

    private String papercode;

    @Column(name = "item_dynamic")
    private Integer itemDynamic;

    /**
     * @return paperId
     */
    public Integer getPaperid() {
        return paperid;
    }

    /**
     * @param paperid
     */
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
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
     * 获取试卷标题
     *
     * @return title - 试卷标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置试卷标题
     *
     * @param title 试卷标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取试卷状态（未上架、已上架、已下架）
     *
     * @return states - 试卷状态（未上架、已上架、已下架）
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置试卷状态（未上架、已上架、已下架）
     *
     * @param states 试卷状态（未上架、已上架、已下架）
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * 获取试卷简介
     *
     * @return description - 试卷简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置试卷简介
     *
     * @param description 试卷简介
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取是否随机出题
     *
     * @return dynamic - 是否随机出题
     */
    public Boolean getDynamic() {
        return dynamic;
    }

    /**
     * 设置是否随机出题
     *
     * @param dynamic 是否随机出题
     */
    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    /**
     * @return orderindextype
     */
    public Integer getOrderindextype() {
        return orderindextype;
    }

    /**
     * @param orderindextype
     */
    public void setOrderindextype(Integer orderindextype) {
        this.orderindextype = orderindextype;
    }

    /**
     * @return papercode
     */
    public String getPapercode() {
        return papercode;
    }

    /**
     * @param papercode
     */
    public void setPapercode(String papercode) {
        this.papercode = papercode;
    }

    /**
     * @return item_dynamic
     */
    public Integer getItemDynamic() {
        return itemDynamic;
    }

    /**
     * @param itemDynamic
     */
    public void setItemDynamic(Integer itemDynamic) {
        this.itemDynamic = itemDynamic;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_infopack")
public class VmbInfopack {
    @Id
    @Column(name = "infoPackId")
    private Integer infopackid;

    /**
     * 所属教学计划
     */
    @Column(name = "trainingProgramId")
    private Integer trainingprogramid;

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
     * 资料包LOGO
     */
    @Column(name = "logoUrl")
    private String logourl;

    /**
     * 所占格子数量
     */
    @Column(name = "cellCount")
    private Integer cellcount;

    /**
     * @return infoPackId
     */
    public Integer getInfopackid() {
        return infopackid;
    }

    /**
     * @param infopackid
     */
    public void setInfopackid(Integer infopackid) {
        this.infopackid = infopackid;
    }

    /**
     * 获取所属教学计划
     *
     * @return trainingProgramId - 所属教学计划
     */
    public Integer getTrainingprogramid() {
        return trainingprogramid;
    }

    /**
     * 设置所属教学计划
     *
     * @param trainingprogramid 所属教学计划
     */
    public void setTrainingprogramid(Integer trainingprogramid) {
        this.trainingprogramid = trainingprogramid;
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
     * 获取资料包LOGO
     *
     * @return logoUrl - 资料包LOGO
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * 设置资料包LOGO
     *
     * @param logourl 资料包LOGO
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
}
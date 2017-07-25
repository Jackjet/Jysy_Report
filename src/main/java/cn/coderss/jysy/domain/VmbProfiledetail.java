package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_profiledetail")
public class VmbProfiledetail {
    @Id
    @Column(name = "profiledetailId")
    private Integer profiledetailid;

    @Column(name = "profileId")
    private Integer profileid;

    @Column(name = "profileType")
    private Integer profiletype;

    private Integer listcount;

    @Column(name = "objectId")
    private Integer objectid;

    private Integer orderindex;

    private Integer pageid;

    private Integer areaid;

    private String title;

    private String url;

    private Integer moduleid;

    private String logourl;

    private String terminal;

    private Integer modular;

    /**
     * 轮播速度
     */
    @Column(name = "round_speed")
    private Integer roundSpeed;

    /**
     * @return profiledetailId
     */
    public Integer getProfiledetailid() {
        return profiledetailid;
    }

    /**
     * @param profiledetailid
     */
    public void setProfiledetailid(Integer profiledetailid) {
        this.profiledetailid = profiledetailid;
    }

    /**
     * @return profileId
     */
    public Integer getProfileid() {
        return profileid;
    }

    /**
     * @param profileid
     */
    public void setProfileid(Integer profileid) {
        this.profileid = profileid;
    }

    /**
     * @return profileType
     */
    public Integer getProfiletype() {
        return profiletype;
    }

    /**
     * @param profiletype
     */
    public void setProfiletype(Integer profiletype) {
        this.profiletype = profiletype;
    }

    /**
     * @return listcount
     */
    public Integer getListcount() {
        return listcount;
    }

    /**
     * @param listcount
     */
    public void setListcount(Integer listcount) {
        this.listcount = listcount;
    }

    /**
     * @return objectId
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * @param objectid
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * @return orderindex
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * @return pageid
     */
    public Integer getPageid() {
        return pageid;
    }

    /**
     * @param pageid
     */
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    /**
     * @return areaid
     */
    public Integer getAreaid() {
        return areaid;
    }

    /**
     * @param areaid
     */
    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return moduleid
     */
    public Integer getModuleid() {
        return moduleid;
    }

    /**
     * @param moduleid
     */
    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    /**
     * @return logourl
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * @param logourl
     */
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    /**
     * @return terminal
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * @param terminal
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * @return modular
     */
    public Integer getModular() {
        return modular;
    }

    /**
     * @param modular
     */
    public void setModular(Integer modular) {
        this.modular = modular;
    }

    /**
     * 获取轮播速度
     *
     * @return round_speed - 轮播速度
     */
    public Integer getRoundSpeed() {
        return roundSpeed;
    }

    /**
     * 设置轮播速度
     *
     * @param roundSpeed 轮播速度
     */
    public void setRoundSpeed(Integer roundSpeed) {
        this.roundSpeed = roundSpeed;
    }
}
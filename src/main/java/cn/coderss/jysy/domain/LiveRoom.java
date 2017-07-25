package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "live_room")
public class LiveRoom {
    @Id
    @Column(name = "live_roomid")
    private Integer liveRoomid;

    /**
     * 直播间名称
     */
    private String name;

    /**
     * 直播间简介
     */
    private String description;

    /**
     * 直播间id
     */
    private Integer channelid;

    /**
     * 直播间logo
     */
    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "cover_img")
    private String coverImg;

    @Column(name = "cover_href")
    private String coverHref;

    @Column(name = "cutoff_img")
    private String cutoffImg;

    @Column(name = "cutoff_href")
    private String cutoffHref;

    @Column(name = "wait_img")
    private String waitImg;

    @Column(name = "wait_href")
    private String waitHref;

    @Column(name = "wait_flv")
    private String waitFlv;

    private String password;

    private Integer states;

    @Column(name = "is_auto_play")
    private Integer isAutoPlay;

    private Date createtime;

    private Integer top;

    private Integer orgid;

    private Integer collegeid;

    private Integer enterpriseid;

    private Date toptime;

    /**
     * @return live_roomid
     */
    public Integer getLiveRoomid() {
        return liveRoomid;
    }

    /**
     * @param liveRoomid
     */
    public void setLiveRoomid(Integer liveRoomid) {
        this.liveRoomid = liveRoomid;
    }

    /**
     * 获取直播间名称
     *
     * @return name - 直播间名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置直播间名称
     *
     * @param name 直播间名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取直播间简介
     *
     * @return description - 直播间简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置直播间简介
     *
     * @param description 直播间简介
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取直播间id
     *
     * @return channelid - 直播间id
     */
    public Integer getChannelid() {
        return channelid;
    }

    /**
     * 设置直播间id
     *
     * @param channelid 直播间id
     */
    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
    }

    /**
     * 获取直播间logo
     *
     * @return logo_url - 直播间logo
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 设置直播间logo
     *
     * @param logoUrl 直播间logo
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * @return cover_img
     */
    public String getCoverImg() {
        return coverImg;
    }

    /**
     * @param coverImg
     */
    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    /**
     * @return cover_href
     */
    public String getCoverHref() {
        return coverHref;
    }

    /**
     * @param coverHref
     */
    public void setCoverHref(String coverHref) {
        this.coverHref = coverHref;
    }

    /**
     * @return cutoff_img
     */
    public String getCutoffImg() {
        return cutoffImg;
    }

    /**
     * @param cutoffImg
     */
    public void setCutoffImg(String cutoffImg) {
        this.cutoffImg = cutoffImg;
    }

    /**
     * @return cutoff_href
     */
    public String getCutoffHref() {
        return cutoffHref;
    }

    /**
     * @param cutoffHref
     */
    public void setCutoffHref(String cutoffHref) {
        this.cutoffHref = cutoffHref;
    }

    /**
     * @return wait_img
     */
    public String getWaitImg() {
        return waitImg;
    }

    /**
     * @param waitImg
     */
    public void setWaitImg(String waitImg) {
        this.waitImg = waitImg;
    }

    /**
     * @return wait_href
     */
    public String getWaitHref() {
        return waitHref;
    }

    /**
     * @param waitHref
     */
    public void setWaitHref(String waitHref) {
        this.waitHref = waitHref;
    }

    /**
     * @return wait_flv
     */
    public String getWaitFlv() {
        return waitFlv;
    }

    /**
     * @param waitFlv
     */
    public void setWaitFlv(String waitFlv) {
        this.waitFlv = waitFlv;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return states
     */
    public Integer getStates() {
        return states;
    }

    /**
     * @param states
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * @return is_auto_play
     */
    public Integer getIsAutoPlay() {
        return isAutoPlay;
    }

    /**
     * @param isAutoPlay
     */
    public void setIsAutoPlay(Integer isAutoPlay) {
        this.isAutoPlay = isAutoPlay;
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
     * @return top
     */
    public Integer getTop() {
        return top;
    }

    /**
     * @param top
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * @return orgid
     */
    public Integer getOrgid() {
        return orgid;
    }

    /**
     * @param orgid
     */
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    /**
     * @return collegeid
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
     * @return enterpriseid
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
     * @return toptime
     */
    public Date getToptime() {
        return toptime;
    }

    /**
     * @param toptime
     */
    public void setToptime(Date toptime) {
        this.toptime = toptime;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "live_schedule")
public class LiveSchedule {
    @Id
    private Integer scheduleid;

    private String name;

    private String presenter;

    @Column(name = "expect_duration")
    private Integer expectDuration;

    private String description;

    private Date createtime;

    private Integer collegeid;

    private Integer enterpriseid;

    @Column(name = "real_starttime")
    private Date realStarttime;

    @Column(name = "real_endtime")
    private Date realEndtime;

    @Column(name = "live_roomid")
    private Integer liveRoomid;

    private Integer duration;

    @Column(name = "push_starttime")
    private Date pushStarttime;

    @Column(name = "push_endtime")
    private Date pushEndtime;

    @Column(name = "logo_url")
    private String logoUrl;

    private Date starttime;

    private Integer status;

    @Column(name = "live_img_url")
    private String liveImgUrl;

    @Column(name = "presenter_img_url")
    private String presenterImgUrl;

    @Column(name = "replay_img_url")
    private String replayImgUrl;

    /**
     * @return scheduleid
     */
    public Integer getScheduleid() {
        return scheduleid;
    }

    /**
     * @param scheduleid
     */
    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return presenter
     */
    public String getPresenter() {
        return presenter;
    }

    /**
     * @param presenter
     */
    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    /**
     * @return expect_duration
     */
    public Integer getExpectDuration() {
        return expectDuration;
    }

    /**
     * @param expectDuration
     */
    public void setExpectDuration(Integer expectDuration) {
        this.expectDuration = expectDuration;
    }

    /**
     * @return description
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
     * @return real_starttime
     */
    public Date getRealStarttime() {
        return realStarttime;
    }

    /**
     * @param realStarttime
     */
    public void setRealStarttime(Date realStarttime) {
        this.realStarttime = realStarttime;
    }

    /**
     * @return real_endtime
     */
    public Date getRealEndtime() {
        return realEndtime;
    }

    /**
     * @param realEndtime
     */
    public void setRealEndtime(Date realEndtime) {
        this.realEndtime = realEndtime;
    }

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
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return push_starttime
     */
    public Date getPushStarttime() {
        return pushStarttime;
    }

    /**
     * @param pushStarttime
     */
    public void setPushStarttime(Date pushStarttime) {
        this.pushStarttime = pushStarttime;
    }

    /**
     * @return push_endtime
     */
    public Date getPushEndtime() {
        return pushEndtime;
    }

    /**
     * @param pushEndtime
     */
    public void setPushEndtime(Date pushEndtime) {
        this.pushEndtime = pushEndtime;
    }

    /**
     * @return logo_url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * @param logoUrl
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * @return starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * @param starttime
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return live_img_url
     */
    public String getLiveImgUrl() {
        return liveImgUrl;
    }

    /**
     * @param liveImgUrl
     */
    public void setLiveImgUrl(String liveImgUrl) {
        this.liveImgUrl = liveImgUrl;
    }

    /**
     * @return presenter_img_url
     */
    public String getPresenterImgUrl() {
        return presenterImgUrl;
    }

    /**
     * @param presenterImgUrl
     */
    public void setPresenterImgUrl(String presenterImgUrl) {
        this.presenterImgUrl = presenterImgUrl;
    }

    /**
     * @return replay_img_url
     */
    public String getReplayImgUrl() {
        return replayImgUrl;
    }

    /**
     * @param replayImgUrl
     */
    public void setReplayImgUrl(String replayImgUrl) {
        this.replayImgUrl = replayImgUrl;
    }
}
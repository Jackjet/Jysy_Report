package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_learninginformation")
public class VmbLearninginformation {
    @Id
    @Column(name = "learningInformationId")
    private Integer learninginformationid;

    @Column(name = "learningScheduleId")
    private Integer learningscheduleid;

    @Column(name = "learningInfoPackId")
    private Integer learninginfopackid;

    @Column(name = "informationId")
    private Integer informationid;

    private String title;

    private Integer infotype;

    private String videourl;

    @Column(name = "recordId")
    private Integer recordid;

    private String fileurl;

    private String redirecturl;

    private Integer orderindex;

    private String logourl;

    private Integer orginalid;

    private Integer duration;

    private Boolean free;

    private Integer learningactivityid;

    /**
     * 是否自动播放，1为自动播放
     */
    private Integer autoplay;

    private String code;

    private String description;

    private String content;

    /**
     * @return learningInformationId
     */
    public Integer getLearninginformationid() {
        return learninginformationid;
    }

    /**
     * @param learninginformationid
     */
    public void setLearninginformationid(Integer learninginformationid) {
        this.learninginformationid = learninginformationid;
    }

    /**
     * @return learningScheduleId
     */
    public Integer getLearningscheduleid() {
        return learningscheduleid;
    }

    /**
     * @param learningscheduleid
     */
    public void setLearningscheduleid(Integer learningscheduleid) {
        this.learningscheduleid = learningscheduleid;
    }

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
     * @return informationId
     */
    public Integer getInformationid() {
        return informationid;
    }

    /**
     * @param informationid
     */
    public void setInformationid(Integer informationid) {
        this.informationid = informationid;
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
     * @return infotype
     */
    public Integer getInfotype() {
        return infotype;
    }

    /**
     * @param infotype
     */
    public void setInfotype(Integer infotype) {
        this.infotype = infotype;
    }

    /**
     * @return videourl
     */
    public String getVideourl() {
        return videourl;
    }

    /**
     * @param videourl
     */
    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    /**
     * @return recordId
     */
    public Integer getRecordid() {
        return recordid;
    }

    /**
     * @param recordid
     */
    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    /**
     * @return fileurl
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * @param fileurl
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    /**
     * @return redirecturl
     */
    public String getRedirecturl() {
        return redirecturl;
    }

    /**
     * @param redirecturl
     */
    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
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
     * @return free
     */
    public Boolean getFree() {
        return free;
    }

    /**
     * @param free
     */
    public void setFree(Boolean free) {
        this.free = free;
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

    /**
     * 获取是否自动播放，1为自动播放
     *
     * @return autoplay - 是否自动播放，1为自动播放
     */
    public Integer getAutoplay() {
        return autoplay;
    }

    /**
     * 设置是否自动播放，1为自动播放
     *
     * @param autoplay 是否自动播放，1为自动播放
     */
    public void setAutoplay(Integer autoplay) {
        this.autoplay = autoplay;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_learningactivity")
public class VmbLearningactivity {
    @Id
    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "trainingSolutionId")
    private Integer trainingsolutionid;

    /**
     * 学习活动名称
     */
    private String name;

    /**
     * 课程LogoUrl
     */
    @Column(name = "logouUrl")
    private String logouurl;

    /**
     * 课程BannerUrl
     */
    @Column(name = "bannerUrl")
    private String bannerurl;

    /**
     * 活动类型（视频、培训班、企业百科、在线文档）
     */
    @Column(name = "actType")
    private Integer acttype;

    /**
     * 预览视频Url
     */
    @Column(name = "previewVideoUrl")
    private String previewvideourl;

    /**
     * 课程视频URL
     */
    @Column(name = "videoUrl")
    private String videourl;

    /**
     * 企业百科内容
     */
    @Column(name = "wikiContent")
    private String wikicontent;

    /**
     * 在线文档Url
     */
    @Column(name = "documentUrl")
    private String documenturl;

    /**
     * 课程首页Url
     */
    @Column(name = "indexPage")
    private String indexpage;

    private String zipfile;

    /**
     * 活动状态（未上架、已上架、已下架）
     */
    private Integer states;

    /**
     * 课程包大小（单位：字节）
     */
    @Column(name = "actSize")
    private Long actsize;

    /**
     * 培训开始时间
     */
    @Column(name = "trainingStartTime")
    private Date trainingstarttime;

    /**
     * 培训结束时间
     */
    @Column(name = "trainingEndTime")
    private Date trainingendtime;

    /**
     * 培训地点
     */
    @Column(name = "trainingAddress")
    private String trainingaddress;

    /**
     * 是否允许自由注册
     */
    @Column(name = "canRegistration")
    private Boolean canregistration;

    /**
     * 参与上限
     */
    private Integer limit;

    private String code;

    private Date createtime;

    /**
     * 0不允许转发1允许转发
     */
    private Integer forward;

    /**
     * 周期（天）
     */
    private Integer cycle;

    /**
     * 周期类型
     */
    private Integer timetype;

    /**
     * 是否顺序播放，1为只能顺序播放
     */
    private Integer limitplay;

    /**
     * 学时
     */
    private Float periods;

    private Integer duration;

    /**
     * 学习活动简介
     */
    private String description;

    /**
     * @return learningActivityId
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
     * @return trainingSolutionId
     */
    public Integer getTrainingsolutionid() {
        return trainingsolutionid;
    }

    /**
     * @param trainingsolutionid
     */
    public void setTrainingsolutionid(Integer trainingsolutionid) {
        this.trainingsolutionid = trainingsolutionid;
    }

    /**
     * 获取学习活动名称
     *
     * @return name - 学习活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学习活动名称
     *
     * @param name 学习活动名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取课程LogoUrl
     *
     * @return logouUrl - 课程LogoUrl
     */
    public String getLogouurl() {
        return logouurl;
    }

    /**
     * 设置课程LogoUrl
     *
     * @param logouurl 课程LogoUrl
     */
    public void setLogouurl(String logouurl) {
        this.logouurl = logouurl;
    }

    /**
     * 获取课程BannerUrl
     *
     * @return bannerUrl - 课程BannerUrl
     */
    public String getBannerurl() {
        return bannerurl;
    }

    /**
     * 设置课程BannerUrl
     *
     * @param bannerurl 课程BannerUrl
     */
    public void setBannerurl(String bannerurl) {
        this.bannerurl = bannerurl;
    }

    /**
     * 获取活动类型（视频、培训班、企业百科、在线文档）
     *
     * @return actType - 活动类型（视频、培训班、企业百科、在线文档）
     */
    public Integer getActtype() {
        return acttype;
    }

    /**
     * 设置活动类型（视频、培训班、企业百科、在线文档）
     *
     * @param acttype 活动类型（视频、培训班、企业百科、在线文档）
     */
    public void setActtype(Integer acttype) {
        this.acttype = acttype;
    }

    /**
     * 获取预览视频Url
     *
     * @return previewVideoUrl - 预览视频Url
     */
    public String getPreviewvideourl() {
        return previewvideourl;
    }

    /**
     * 设置预览视频Url
     *
     * @param previewvideourl 预览视频Url
     */
    public void setPreviewvideourl(String previewvideourl) {
        this.previewvideourl = previewvideourl;
    }

    /**
     * 获取课程视频URL
     *
     * @return videoUrl - 课程视频URL
     */
    public String getVideourl() {
        return videourl;
    }

    /**
     * 设置课程视频URL
     *
     * @param videourl 课程视频URL
     */
    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    /**
     * 获取企业百科内容
     *
     * @return wikiContent - 企业百科内容
     */
    public String getWikicontent() {
        return wikicontent;
    }

    /**
     * 设置企业百科内容
     *
     * @param wikicontent 企业百科内容
     */
    public void setWikicontent(String wikicontent) {
        this.wikicontent = wikicontent;
    }

    /**
     * 获取在线文档Url
     *
     * @return documentUrl - 在线文档Url
     */
    public String getDocumenturl() {
        return documenturl;
    }

    /**
     * 设置在线文档Url
     *
     * @param documenturl 在线文档Url
     */
    public void setDocumenturl(String documenturl) {
        this.documenturl = documenturl;
    }

    /**
     * 获取课程首页Url
     *
     * @return indexPage - 课程首页Url
     */
    public String getIndexpage() {
        return indexpage;
    }

    /**
     * 设置课程首页Url
     *
     * @param indexpage 课程首页Url
     */
    public void setIndexpage(String indexpage) {
        this.indexpage = indexpage;
    }

    /**
     * @return zipfile
     */
    public String getZipfile() {
        return zipfile;
    }

    /**
     * @param zipfile
     */
    public void setZipfile(String zipfile) {
        this.zipfile = zipfile;
    }

    /**
     * 获取活动状态（未上架、已上架、已下架）
     *
     * @return states - 活动状态（未上架、已上架、已下架）
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置活动状态（未上架、已上架、已下架）
     *
     * @param states 活动状态（未上架、已上架、已下架）
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * 获取课程包大小（单位：字节）
     *
     * @return actSize - 课程包大小（单位：字节）
     */
    public Long getActsize() {
        return actsize;
    }

    /**
     * 设置课程包大小（单位：字节）
     *
     * @param actsize 课程包大小（单位：字节）
     */
    public void setActsize(Long actsize) {
        this.actsize = actsize;
    }

    /**
     * 获取培训开始时间
     *
     * @return trainingStartTime - 培训开始时间
     */
    public Date getTrainingstarttime() {
        return trainingstarttime;
    }

    /**
     * 设置培训开始时间
     *
     * @param trainingstarttime 培训开始时间
     */
    public void setTrainingstarttime(Date trainingstarttime) {
        this.trainingstarttime = trainingstarttime;
    }

    /**
     * 获取培训结束时间
     *
     * @return trainingEndTime - 培训结束时间
     */
    public Date getTrainingendtime() {
        return trainingendtime;
    }

    /**
     * 设置培训结束时间
     *
     * @param trainingendtime 培训结束时间
     */
    public void setTrainingendtime(Date trainingendtime) {
        this.trainingendtime = trainingendtime;
    }

    /**
     * 获取培训地点
     *
     * @return trainingAddress - 培训地点
     */
    public String getTrainingaddress() {
        return trainingaddress;
    }

    /**
     * 设置培训地点
     *
     * @param trainingaddress 培训地点
     */
    public void setTrainingaddress(String trainingaddress) {
        this.trainingaddress = trainingaddress;
    }

    /**
     * 获取是否允许自由注册
     *
     * @return canRegistration - 是否允许自由注册
     */
    public Boolean getCanregistration() {
        return canregistration;
    }

    /**
     * 设置是否允许自由注册
     *
     * @param canregistration 是否允许自由注册
     */
    public void setCanregistration(Boolean canregistration) {
        this.canregistration = canregistration;
    }

    /**
     * 获取参与上限
     *
     * @return limit - 参与上限
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * 设置参与上限
     *
     * @param limit 参与上限
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
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
     * 获取0不允许转发1允许转发
     *
     * @return forward - 0不允许转发1允许转发
     */
    public Integer getForward() {
        return forward;
    }

    /**
     * 设置0不允许转发1允许转发
     *
     * @param forward 0不允许转发1允许转发
     */
    public void setForward(Integer forward) {
        this.forward = forward;
    }

    /**
     * 获取周期（天）
     *
     * @return cycle - 周期（天）
     */
    public Integer getCycle() {
        return cycle;
    }

    /**
     * 设置周期（天）
     *
     * @param cycle 周期（天）
     */
    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    /**
     * 获取周期类型
     *
     * @return timetype - 周期类型
     */
    public Integer getTimetype() {
        return timetype;
    }

    /**
     * 设置周期类型
     *
     * @param timetype 周期类型
     */
    public void setTimetype(Integer timetype) {
        this.timetype = timetype;
    }

    /**
     * 获取是否顺序播放，1为只能顺序播放
     *
     * @return limitplay - 是否顺序播放，1为只能顺序播放
     */
    public Integer getLimitplay() {
        return limitplay;
    }

    /**
     * 设置是否顺序播放，1为只能顺序播放
     *
     * @param limitplay 是否顺序播放，1为只能顺序播放
     */
    public void setLimitplay(Integer limitplay) {
        this.limitplay = limitplay;
    }

    /**
     * 获取学时
     *
     * @return periods - 学时
     */
    public Float getPeriods() {
        return periods;
    }

    /**
     * 设置学时
     *
     * @param periods 学时
     */
    public void setPeriods(Float periods) {
        this.periods = periods;
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
     * 获取学习活动简介
     *
     * @return description - 学习活动简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置学习活动简介
     *
     * @param description 学习活动简介
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
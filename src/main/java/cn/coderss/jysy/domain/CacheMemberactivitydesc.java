package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cache_memberactivitydesc")
public class CacheMemberactivitydesc {
    @Column(name = "LearningActivityId")
    private Integer learningactivityid;

    /**
     * 学习活动名称
     */
    private String name;

    /**
     * 课程LogoUrl
     */
    private String logouurl;

    /**
     * 课程首页Url
     */
    private String indexpage;

    /**
     * 课程视频URL
     */
    private String videourl;

    /**
     * 在线文档Url
     */
    private String documenturl;

    private String zipfile;

    /**
     * 课程BannerUrl
     */
    @Column(name = "BannerUrl")
    private String bannerurl;

    /**
     * 预览视频Url
     */
    @Column(name = "PreviewVideoUrl")
    private String previewvideourl;

    /**
     * 活动状态（未上架、已上架、已下架）
     */
    private Integer states;

    /**
     * 活动类型（视频、培训班、企业百科、在线文档）
     */
    private Integer acttype;

    /**
     * 课程包大小（单位：字节）
     */
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

    @Column(name = "trainingSolutionId")
    private Integer trainingsolutionid;

    private Long commentcount;

    private Long favoritecount;

    private Long footmarkcount;

    private BigDecimal threegradepercent;

    private BigDecimal foregradepercent;

    private BigDecimal fivegradepercent;

    private BigDecimal onegradepercent;

    private BigDecimal twogradepercent;

    private Integer studiescount;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 分配的目标成员
     */
    @Column(name = "destMemberId")
    private Integer destmemberid;

    private Integer collegeid;

    @Column(name = "mem_recommend")
    private Boolean memRecommend;

    @Column(name = "cl_recommend")
    private Integer clRecommend;

    private Boolean recommend;

    private Date createtime;

    /**
     * 是否必修
     */
    private Boolean required;

    private Integer orderindex;

    /**
     * 学习活动简介
     */
    private String description;

    /**
     * @return LearningActivityId
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
     * @return logouurl - 课程LogoUrl
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
     * 获取课程首页Url
     *
     * @return indexpage - 课程首页Url
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
     * 获取课程视频URL
     *
     * @return videourl - 课程视频URL
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
     * 获取在线文档Url
     *
     * @return documenturl - 在线文档Url
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
     * 获取课程BannerUrl
     *
     * @return BannerUrl - 课程BannerUrl
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
     * 获取预览视频Url
     *
     * @return PreviewVideoUrl - 预览视频Url
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
     * 获取活动类型（视频、培训班、企业百科、在线文档）
     *
     * @return acttype - 活动类型（视频、培训班、企业百科、在线文档）
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
     * 获取课程包大小（单位：字节）
     *
     * @return actsize - 课程包大小（单位：字节）
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
     * @return commentcount
     */
    public Long getCommentcount() {
        return commentcount;
    }

    /**
     * @param commentcount
     */
    public void setCommentcount(Long commentcount) {
        this.commentcount = commentcount;
    }

    /**
     * @return favoritecount
     */
    public Long getFavoritecount() {
        return favoritecount;
    }

    /**
     * @param favoritecount
     */
    public void setFavoritecount(Long favoritecount) {
        this.favoritecount = favoritecount;
    }

    /**
     * @return footmarkcount
     */
    public Long getFootmarkcount() {
        return footmarkcount;
    }

    /**
     * @param footmarkcount
     */
    public void setFootmarkcount(Long footmarkcount) {
        this.footmarkcount = footmarkcount;
    }

    /**
     * @return threegradepercent
     */
    public BigDecimal getThreegradepercent() {
        return threegradepercent;
    }

    /**
     * @param threegradepercent
     */
    public void setThreegradepercent(BigDecimal threegradepercent) {
        this.threegradepercent = threegradepercent;
    }

    /**
     * @return foregradepercent
     */
    public BigDecimal getForegradepercent() {
        return foregradepercent;
    }

    /**
     * @param foregradepercent
     */
    public void setForegradepercent(BigDecimal foregradepercent) {
        this.foregradepercent = foregradepercent;
    }

    /**
     * @return fivegradepercent
     */
    public BigDecimal getFivegradepercent() {
        return fivegradepercent;
    }

    /**
     * @param fivegradepercent
     */
    public void setFivegradepercent(BigDecimal fivegradepercent) {
        this.fivegradepercent = fivegradepercent;
    }

    /**
     * @return onegradepercent
     */
    public BigDecimal getOnegradepercent() {
        return onegradepercent;
    }

    /**
     * @param onegradepercent
     */
    public void setOnegradepercent(BigDecimal onegradepercent) {
        this.onegradepercent = onegradepercent;
    }

    /**
     * @return twogradepercent
     */
    public BigDecimal getTwogradepercent() {
        return twogradepercent;
    }

    /**
     * @param twogradepercent
     */
    public void setTwogradepercent(BigDecimal twogradepercent) {
        this.twogradepercent = twogradepercent;
    }

    /**
     * @return studiescount
     */
    public Integer getStudiescount() {
        return studiescount;
    }

    /**
     * @param studiescount
     */
    public void setStudiescount(Integer studiescount) {
        this.studiescount = studiescount;
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
     * 获取分配的目标成员
     *
     * @return destMemberId - 分配的目标成员
     */
    public Integer getDestmemberid() {
        return destmemberid;
    }

    /**
     * 设置分配的目标成员
     *
     * @param destmemberid 分配的目标成员
     */
    public void setDestmemberid(Integer destmemberid) {
        this.destmemberid = destmemberid;
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
     * @return mem_recommend
     */
    public Boolean getMemRecommend() {
        return memRecommend;
    }

    /**
     * @param memRecommend
     */
    public void setMemRecommend(Boolean memRecommend) {
        this.memRecommend = memRecommend;
    }

    /**
     * @return cl_recommend
     */
    public Integer getClRecommend() {
        return clRecommend;
    }

    /**
     * @param clRecommend
     */
    public void setClRecommend(Integer clRecommend) {
        this.clRecommend = clRecommend;
    }

    /**
     * @return recommend
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
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
     * 获取是否必修
     *
     * @return required - 是否必修
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * 设置是否必修
     *
     * @param required 是否必修
     */
    public void setRequired(Boolean required) {
        this.required = required;
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
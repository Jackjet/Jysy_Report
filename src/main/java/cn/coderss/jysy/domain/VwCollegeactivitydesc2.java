package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_collegeactivitydesc_2")
public class VwCollegeactivitydesc2 {
    @Column(name = "LearningActivityId")
    private Byte learningactivityid;

    private Byte name;

    private Byte description;

    private Byte logouurl;

    private Byte indexpage;

    private Byte videourl;

    private Byte documenturl;

    private Byte zipfile;

    @Column(name = "BannerUrl")
    private Byte bannerurl;

    @Column(name = "PreviewVideoUrl")
    private Byte previewvideourl;

    private Byte states;

    private Byte acttype;

    private Byte actsize;

    @Column(name = "trainingStartTime")
    private Byte trainingstarttime;

    @Column(name = "trainingEndTime")
    private Byte trainingendtime;

    @Column(name = "trainingSolutionId")
    private Byte trainingsolutionid;

    private Byte commentcount;

    private Byte favoritecount;

    private Byte footmarkcount;

    private Byte threegradepercent;

    private Byte foregradepercent;

    private Byte fivegradepercent;

    private Byte onegradepercent;

    private Byte twogradepercent;

    private Byte studiescount;

    private Byte collegeid;

    @Column(name = "cl_recommend")
    private Byte clRecommend;

    @Column(name = "mem_recommend")
    private Byte memRecommend;

    private Byte recommend;

    private Byte createtime;

    private Byte orderindex;

    /**
     * @return LearningActivityId
     */
    public Byte getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * @param learningactivityid
     */
    public void setLearningactivityid(Byte learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * @return name
     */
    public Byte getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(Byte name) {
        this.name = name;
    }

    /**
     * @return description
     */
    public Byte getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(Byte description) {
        this.description = description;
    }

    /**
     * @return logouurl
     */
    public Byte getLogouurl() {
        return logouurl;
    }

    /**
     * @param logouurl
     */
    public void setLogouurl(Byte logouurl) {
        this.logouurl = logouurl;
    }

    /**
     * @return indexpage
     */
    public Byte getIndexpage() {
        return indexpage;
    }

    /**
     * @param indexpage
     */
    public void setIndexpage(Byte indexpage) {
        this.indexpage = indexpage;
    }

    /**
     * @return videourl
     */
    public Byte getVideourl() {
        return videourl;
    }

    /**
     * @param videourl
     */
    public void setVideourl(Byte videourl) {
        this.videourl = videourl;
    }

    /**
     * @return documenturl
     */
    public Byte getDocumenturl() {
        return documenturl;
    }

    /**
     * @param documenturl
     */
    public void setDocumenturl(Byte documenturl) {
        this.documenturl = documenturl;
    }

    /**
     * @return zipfile
     */
    public Byte getZipfile() {
        return zipfile;
    }

    /**
     * @param zipfile
     */
    public void setZipfile(Byte zipfile) {
        this.zipfile = zipfile;
    }

    /**
     * @return BannerUrl
     */
    public Byte getBannerurl() {
        return bannerurl;
    }

    /**
     * @param bannerurl
     */
    public void setBannerurl(Byte bannerurl) {
        this.bannerurl = bannerurl;
    }

    /**
     * @return PreviewVideoUrl
     */
    public Byte getPreviewvideourl() {
        return previewvideourl;
    }

    /**
     * @param previewvideourl
     */
    public void setPreviewvideourl(Byte previewvideourl) {
        this.previewvideourl = previewvideourl;
    }

    /**
     * @return states
     */
    public Byte getStates() {
        return states;
    }

    /**
     * @param states
     */
    public void setStates(Byte states) {
        this.states = states;
    }

    /**
     * @return acttype
     */
    public Byte getActtype() {
        return acttype;
    }

    /**
     * @param acttype
     */
    public void setActtype(Byte acttype) {
        this.acttype = acttype;
    }

    /**
     * @return actsize
     */
    public Byte getActsize() {
        return actsize;
    }

    /**
     * @param actsize
     */
    public void setActsize(Byte actsize) {
        this.actsize = actsize;
    }

    /**
     * @return trainingStartTime
     */
    public Byte getTrainingstarttime() {
        return trainingstarttime;
    }

    /**
     * @param trainingstarttime
     */
    public void setTrainingstarttime(Byte trainingstarttime) {
        this.trainingstarttime = trainingstarttime;
    }

    /**
     * @return trainingEndTime
     */
    public Byte getTrainingendtime() {
        return trainingendtime;
    }

    /**
     * @param trainingendtime
     */
    public void setTrainingendtime(Byte trainingendtime) {
        this.trainingendtime = trainingendtime;
    }

    /**
     * @return trainingSolutionId
     */
    public Byte getTrainingsolutionid() {
        return trainingsolutionid;
    }

    /**
     * @param trainingsolutionid
     */
    public void setTrainingsolutionid(Byte trainingsolutionid) {
        this.trainingsolutionid = trainingsolutionid;
    }

    /**
     * @return commentcount
     */
    public Byte getCommentcount() {
        return commentcount;
    }

    /**
     * @param commentcount
     */
    public void setCommentcount(Byte commentcount) {
        this.commentcount = commentcount;
    }

    /**
     * @return favoritecount
     */
    public Byte getFavoritecount() {
        return favoritecount;
    }

    /**
     * @param favoritecount
     */
    public void setFavoritecount(Byte favoritecount) {
        this.favoritecount = favoritecount;
    }

    /**
     * @return footmarkcount
     */
    public Byte getFootmarkcount() {
        return footmarkcount;
    }

    /**
     * @param footmarkcount
     */
    public void setFootmarkcount(Byte footmarkcount) {
        this.footmarkcount = footmarkcount;
    }

    /**
     * @return threegradepercent
     */
    public Byte getThreegradepercent() {
        return threegradepercent;
    }

    /**
     * @param threegradepercent
     */
    public void setThreegradepercent(Byte threegradepercent) {
        this.threegradepercent = threegradepercent;
    }

    /**
     * @return foregradepercent
     */
    public Byte getForegradepercent() {
        return foregradepercent;
    }

    /**
     * @param foregradepercent
     */
    public void setForegradepercent(Byte foregradepercent) {
        this.foregradepercent = foregradepercent;
    }

    /**
     * @return fivegradepercent
     */
    public Byte getFivegradepercent() {
        return fivegradepercent;
    }

    /**
     * @param fivegradepercent
     */
    public void setFivegradepercent(Byte fivegradepercent) {
        this.fivegradepercent = fivegradepercent;
    }

    /**
     * @return onegradepercent
     */
    public Byte getOnegradepercent() {
        return onegradepercent;
    }

    /**
     * @param onegradepercent
     */
    public void setOnegradepercent(Byte onegradepercent) {
        this.onegradepercent = onegradepercent;
    }

    /**
     * @return twogradepercent
     */
    public Byte getTwogradepercent() {
        return twogradepercent;
    }

    /**
     * @param twogradepercent
     */
    public void setTwogradepercent(Byte twogradepercent) {
        this.twogradepercent = twogradepercent;
    }

    /**
     * @return studiescount
     */
    public Byte getStudiescount() {
        return studiescount;
    }

    /**
     * @param studiescount
     */
    public void setStudiescount(Byte studiescount) {
        this.studiescount = studiescount;
    }

    /**
     * @return collegeid
     */
    public Byte getCollegeid() {
        return collegeid;
    }

    /**
     * @param collegeid
     */
    public void setCollegeid(Byte collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * @return cl_recommend
     */
    public Byte getClRecommend() {
        return clRecommend;
    }

    /**
     * @param clRecommend
     */
    public void setClRecommend(Byte clRecommend) {
        this.clRecommend = clRecommend;
    }

    /**
     * @return mem_recommend
     */
    public Byte getMemRecommend() {
        return memRecommend;
    }

    /**
     * @param memRecommend
     */
    public void setMemRecommend(Byte memRecommend) {
        this.memRecommend = memRecommend;
    }

    /**
     * @return recommend
     */
    public Byte getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    /**
     * @return createtime
     */
    public Byte getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Byte createtime) {
        this.createtime = createtime;
    }

    /**
     * @return orderindex
     */
    public Byte getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Byte orderindex) {
        this.orderindex = orderindex;
    }
}
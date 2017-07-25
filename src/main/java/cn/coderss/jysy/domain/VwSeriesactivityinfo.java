package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_seriesactivityinfo")
public class VwSeriesactivityinfo {
    @Column(name = "learningActivityId")
    private Byte learningactivityid;

    private Byte name;

    private Byte bannerurl;

    private Byte acttype;

    @Column(name = "accountId")
    private Byte accountid;

    private Byte overed;

    private Byte opentime;

    private Byte end;

    /**
     * @return learningActivityId
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
     * @return bannerurl
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
     * @return accountId
     */
    public Byte getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Byte accountid) {
        this.accountid = accountid;
    }

    /**
     * @return overed
     */
    public Byte getOvered() {
        return overed;
    }

    /**
     * @param overed
     */
    public void setOvered(Byte overed) {
        this.overed = overed;
    }

    /**
     * @return opentime
     */
    public Byte getOpentime() {
        return opentime;
    }

    /**
     * @param opentime
     */
    public void setOpentime(Byte opentime) {
        this.opentime = opentime;
    }

    /**
     * @return end
     */
    public Byte getEnd() {
        return end;
    }

    /**
     * @param end
     */
    public void setEnd(Byte end) {
        this.end = end;
    }
}
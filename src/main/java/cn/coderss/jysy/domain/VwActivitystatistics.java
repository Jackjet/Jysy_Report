package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_activitystatistics")
public class VwActivitystatistics {
    private Byte learningactivityid;

    private Byte commentcount;

    private Byte favoritecount;

    private Byte footmarkcount;

    private Byte studiescount;

    private Byte onegradepercent;

    private Byte twogradepercent;

    private Byte threegradepercent;

    private Byte foregradepercent;

    private Byte fivegradepercent;

    private Byte studysecond;

    private Byte averagesecond;

    private Byte accountcount;

    /**
     * @return learningactivityid
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
     * @return studysecond
     */
    public Byte getStudysecond() {
        return studysecond;
    }

    /**
     * @param studysecond
     */
    public void setStudysecond(Byte studysecond) {
        this.studysecond = studysecond;
    }

    /**
     * @return averagesecond
     */
    public Byte getAveragesecond() {
        return averagesecond;
    }

    /**
     * @param averagesecond
     */
    public void setAveragesecond(Byte averagesecond) {
        this.averagesecond = averagesecond;
    }

    /**
     * @return accountcount
     */
    public Byte getAccountcount() {
        return accountcount;
    }

    /**
     * @param accountcount
     */
    public void setAccountcount(Byte accountcount) {
        this.accountcount = accountcount;
    }
}
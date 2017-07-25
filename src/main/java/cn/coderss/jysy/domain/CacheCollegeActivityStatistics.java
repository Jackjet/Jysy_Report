package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "cache_college_activity_statistics")
public class CacheCollegeActivityStatistics {
    private Integer collegeid;

    private Integer learningactivityid;

    private Long commentcount;

    private Long favoritecount;

    private Long footmarkcount;

    private BigDecimal onegradepercent;

    private BigDecimal twogradepercent;

    private BigDecimal threegradepercent;

    private BigDecimal foregradepercent;

    private BigDecimal fivegradepercent;

    private Integer studiescount;

    /**
     * 学员总数
     */
    private Integer accountcount;

    /**
     * 总学习时长s
     */
    private Integer studysecond;

    /**
     * 平均学习时长
     */
    private Integer averagesecond;

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
     * 获取学员总数
     *
     * @return accountcount - 学员总数
     */
    public Integer getAccountcount() {
        return accountcount;
    }

    /**
     * 设置学员总数
     *
     * @param accountcount 学员总数
     */
    public void setAccountcount(Integer accountcount) {
        this.accountcount = accountcount;
    }

    /**
     * 获取总学习时长s
     *
     * @return studysecond - 总学习时长s
     */
    public Integer getStudysecond() {
        return studysecond;
    }

    /**
     * 设置总学习时长s
     *
     * @param studysecond 总学习时长s
     */
    public void setStudysecond(Integer studysecond) {
        this.studysecond = studysecond;
    }

    /**
     * 获取平均学习时长
     *
     * @return averagesecond - 平均学习时长
     */
    public Integer getAveragesecond() {
        return averagesecond;
    }

    /**
     * 设置平均学习时长
     *
     * @param averagesecond 平均学习时长
     */
    public void setAveragesecond(Integer averagesecond) {
        this.averagesecond = averagesecond;
    }
}
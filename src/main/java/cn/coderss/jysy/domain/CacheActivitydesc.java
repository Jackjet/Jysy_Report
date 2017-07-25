package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "cache_activitydesc")
public class CacheActivitydesc {
    @Id
    private Long activitydescid;

    @Column(name = "LearningActivityId")
    private Integer learningactivityid;

    /**
     * 活动状态（未上架、已上架、已下架）
     */
    private Integer states;

    /**
     * 活动类型（视频、培训班、企业百科、在线文档）
     */
    private Integer acttype;

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

    private Integer collegeid;

    @Column(name = "cl_recommend")
    private Byte clRecommend;

    @Column(name = "mem_recommend")
    private Integer memRecommend;

    /**
     * @return activitydescid
     */
    public Long getActivitydescid() {
        return activitydescid;
    }

    /**
     * @param activitydescid
     */
    public void setActivitydescid(Long activitydescid) {
        this.activitydescid = activitydescid;
    }

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
    public Integer getMemRecommend() {
        return memRecommend;
    }

    /**
     * @param memRecommend
     */
    public void setMemRecommend(Integer memRecommend) {
        this.memRecommend = memRecommend;
    }
}
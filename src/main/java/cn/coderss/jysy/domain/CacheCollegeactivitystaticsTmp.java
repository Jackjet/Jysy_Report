package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_collegeactivitystatics_tmp")
public class CacheCollegeactivitystaticsTmp {
    @Id
    private Integer learningactivityid;

    @Id
    private Integer collegeid;

    private Integer enterpriseid;

    /**
     * 分配会员数量
     */
    private Integer accountcount;

    /**
     * 学习数量
     */
    private Integer studycount;

    /**
     * 学习时间
     */
    private Integer studysecond;

    /**
     * 平均时间
     */
    private Integer averagesecond;

    /**
     * 收藏
     */
    private Integer favoritecount;

    /**
     * 好评率
     */
    private Long grade;

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
     * 获取分配会员数量
     *
     * @return accountcount - 分配会员数量
     */
    public Integer getAccountcount() {
        return accountcount;
    }

    /**
     * 设置分配会员数量
     *
     * @param accountcount 分配会员数量
     */
    public void setAccountcount(Integer accountcount) {
        this.accountcount = accountcount;
    }

    /**
     * 获取学习数量
     *
     * @return studycount - 学习数量
     */
    public Integer getStudycount() {
        return studycount;
    }

    /**
     * 设置学习数量
     *
     * @param studycount 学习数量
     */
    public void setStudycount(Integer studycount) {
        this.studycount = studycount;
    }

    /**
     * 获取学习时间
     *
     * @return studysecond - 学习时间
     */
    public Integer getStudysecond() {
        return studysecond;
    }

    /**
     * 设置学习时间
     *
     * @param studysecond 学习时间
     */
    public void setStudysecond(Integer studysecond) {
        this.studysecond = studysecond;
    }

    /**
     * 获取平均时间
     *
     * @return averagesecond - 平均时间
     */
    public Integer getAveragesecond() {
        return averagesecond;
    }

    /**
     * 设置平均时间
     *
     * @param averagesecond 平均时间
     */
    public void setAveragesecond(Integer averagesecond) {
        this.averagesecond = averagesecond;
    }

    /**
     * 获取收藏
     *
     * @return favoritecount - 收藏
     */
    public Integer getFavoritecount() {
        return favoritecount;
    }

    /**
     * 设置收藏
     *
     * @param favoritecount 收藏
     */
    public void setFavoritecount(Integer favoritecount) {
        this.favoritecount = favoritecount;
    }

    /**
     * 获取好评率
     *
     * @return grade - 好评率
     */
    public Long getGrade() {
        return grade;
    }

    /**
     * 设置好评率
     *
     * @param grade 好评率
     */
    public void setGrade(Long grade) {
        this.grade = grade;
    }
}
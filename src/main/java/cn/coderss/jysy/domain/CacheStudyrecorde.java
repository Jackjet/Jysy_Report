package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_studyrecorde")
public class CacheStudyrecorde {
    /**
     * 课程Id
     */
    @Id
    private Integer learningactivityid;

    /**
     * 用户Id
     */
    @Id
    private Integer accountid;

    @Id
    private Integer collegeid;

    /**
     * 获取课程Id
     *
     * @return learningactivityid - 课程Id
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置课程Id
     *
     * @param learningactivityid 课程Id
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取用户Id
     *
     * @return accountid - 用户Id
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置用户Id
     *
     * @param accountid 用户Id
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
}
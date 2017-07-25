package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_coursestates")
public class CacheCoursestates {
    private Integer learningactivityid;

    private Integer chapterid;

    private Integer accountid;

    private Integer overed;

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
     * @return chapterid
     */
    public Integer getChapterid() {
        return chapterid;
    }

    /**
     * @param chapterid
     */
    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    /**
     * @return accountid
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
     * @return overed
     */
    public Integer getOvered() {
        return overed;
    }

    /**
     * @param overed
     */
    public void setOvered(Integer overed) {
        this.overed = overed;
    }
}
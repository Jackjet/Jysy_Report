package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_accountcoursestates")
public class CacheAccountcoursestates {
    private Integer learningactivityid;

    /**
     * 用户Id
     */
    private Integer accountid;

    private Integer licount;

    private Integer chaptercount;

    private Integer sucessfuled;

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
     * @return licount
     */
    public Integer getLicount() {
        return licount;
    }

    /**
     * @param licount
     */
    public void setLicount(Integer licount) {
        this.licount = licount;
    }

    /**
     * @return chaptercount
     */
    public Integer getChaptercount() {
        return chaptercount;
    }

    /**
     * @param chaptercount
     */
    public void setChaptercount(Integer chaptercount) {
        this.chaptercount = chaptercount;
    }

    /**
     * @return sucessfuled
     */
    public Integer getSucessfuled() {
        return sucessfuled;
    }

    /**
     * @param sucessfuled
     */
    public void setSucessfuled(Integer sucessfuled) {
        this.sucessfuled = sucessfuled;
    }
}
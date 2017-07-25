package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_coursestates")
public class VwCoursestates {
    private Byte learningactivityid;

    private Byte chapterid;

    private Byte accountid;

    private Byte overed;

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
     * @return chapterid
     */
    public Byte getChapterid() {
        return chapterid;
    }

    /**
     * @param chapterid
     */
    public void setChapterid(Byte chapterid) {
        this.chapterid = chapterid;
    }

    /**
     * @return accountid
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
}
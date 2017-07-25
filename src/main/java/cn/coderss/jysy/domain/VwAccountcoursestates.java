package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_accountcoursestates")
public class VwAccountcoursestates {
    private Byte learningactivityid;

    private Byte accountid;

    private Byte overed;

    private Byte licount;

    private Byte chaptercount;

    private Byte sucessfuled;

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

    /**
     * @return licount
     */
    public Byte getLicount() {
        return licount;
    }

    /**
     * @param licount
     */
    public void setLicount(Byte licount) {
        this.licount = licount;
    }

    /**
     * @return chaptercount
     */
    public Byte getChaptercount() {
        return chaptercount;
    }

    /**
     * @param chaptercount
     */
    public void setChaptercount(Byte chaptercount) {
        this.chaptercount = chaptercount;
    }

    /**
     * @return sucessfuled
     */
    public Byte getSucessfuled() {
        return sucessfuled;
    }

    /**
     * @param sucessfuled
     */
    public void setSucessfuled(Byte sucessfuled) {
        this.sucessfuled = sucessfuled;
    }
}
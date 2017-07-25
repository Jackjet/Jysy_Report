package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_coursechapters")
public class VwCoursechapters {
    private Byte learningactivityid;

    private Byte chapterid;

    private Byte acttype;

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
}
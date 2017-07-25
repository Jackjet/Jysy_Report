package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_coursechapters")
public class CacheCoursechapters {
    private Integer learningactivityid;

    private Integer chapterid;

    private Integer acttype;

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
     * @return acttype
     */
    public Integer getActtype() {
        return acttype;
    }

    /**
     * @param acttype
     */
    public void setActtype(Integer acttype) {
        this.acttype = acttype;
    }
}
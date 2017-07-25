package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_documentpages")
public class VmbDocumentpages {
    @Id
    private Integer pageid;

    private Integer chapterid;

    private Integer learningactivityid;

    private String pageurl;

    private Integer width;

    private Integer height;

    /**
     * @return pageid
     */
    public Integer getPageid() {
        return pageid;
    }

    /**
     * @param pageid
     */
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
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
     * @return pageurl
     */
    public String getPageurl() {
        return pageurl;
    }

    /**
     * @param pageurl
     */
    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }

    /**
     * @return width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }
}
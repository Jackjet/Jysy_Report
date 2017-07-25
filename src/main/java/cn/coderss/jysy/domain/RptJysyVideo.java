package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "rpt_jysy_video")
public class RptJysyVideo {
    @Id
    private Integer videoid;

    private Integer learningactivityid;

    private Integer chapterid;

    private String title;

    private String vid;

    private String coursetype;

    /**
     * @return videoid
     */
    public Integer getVideoid() {
        return videoid;
    }

    /**
     * @param videoid
     */
    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return vid
     */
    public String getVid() {
        return vid;
    }

    /**
     * @param vid
     */
    public void setVid(String vid) {
        this.vid = vid;
    }

    /**
     * @return coursetype
     */
    public String getCoursetype() {
        return coursetype;
    }

    /**
     * @param coursetype
     */
    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }
}
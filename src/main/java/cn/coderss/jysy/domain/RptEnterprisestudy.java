package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "rpt_enterprisestudy")
public class RptEnterprisestudy {
    @Id
    private Integer rptid;

    private Integer enterpriseid;

    private String entname;

    private Integer learningactivityid;

    private String coursename;

    private String acttype;

    private Integer chaptercount;

    private Integer duration;

    private Integer accountcount;

    /**
     * @return rptid
     */
    public Integer getRptid() {
        return rptid;
    }

    /**
     * @param rptid
     */
    public void setRptid(Integer rptid) {
        this.rptid = rptid;
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
     * @return entname
     */
    public String getEntname() {
        return entname;
    }

    /**
     * @param entname
     */
    public void setEntname(String entname) {
        this.entname = entname;
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
     * @return coursename
     */
    public String getCoursename() {
        return coursename;
    }

    /**
     * @param coursename
     */
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    /**
     * @return acttype
     */
    public String getActtype() {
        return acttype;
    }

    /**
     * @param acttype
     */
    public void setActtype(String acttype) {
        this.acttype = acttype;
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
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return accountcount
     */
    public Integer getAccountcount() {
        return accountcount;
    }

    /**
     * @param accountcount
     */
    public void setAccountcount(Integer accountcount) {
        this.accountcount = accountcount;
    }
}
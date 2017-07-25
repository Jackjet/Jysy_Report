package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_examanswerpaper")
public class VmbExamanswerpaper {
    @Id
    @Column(name = "accountExamId")
    private Integer accountexamid;

    @Column(name = "accountId")
    private Integer accountid;

    @Column(name = "examinationId")
    private Integer examinationid;

    @Column(name = "paperId")
    private Integer paperid;

    private Date starttime;

    private Date endtime;

    private Boolean commited;

    private Float score;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * @return accountExamId
     */
    public Integer getAccountexamid() {
        return accountexamid;
    }

    /**
     * @param accountexamid
     */
    public void setAccountexamid(Integer accountexamid) {
        this.accountexamid = accountexamid;
    }

    /**
     * @return accountId
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
     * @return examinationId
     */
    public Integer getExaminationid() {
        return examinationid;
    }

    /**
     * @param examinationid
     */
    public void setExaminationid(Integer examinationid) {
        this.examinationid = examinationid;
    }

    /**
     * @return paperId
     */
    public Integer getPaperid() {
        return paperid;
    }

    /**
     * @param paperid
     */
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    /**
     * @return starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * @param starttime
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * @return endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * @return commited
     */
    public Boolean getCommited() {
        return commited;
    }

    /**
     * @param commited
     */
    public void setCommited(Boolean commited) {
        this.commited = commited;
    }

    /**
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * @return collegeId
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

    /**
     * @return enterpriseId
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
}
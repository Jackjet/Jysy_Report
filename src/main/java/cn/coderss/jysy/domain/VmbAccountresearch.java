package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_accountresearch")
public class VmbAccountresearch {
    @Id
    @Column(name = "accountsurveyId")
    private Integer accountsurveyid;

    @Column(name = "accountId")
    private Integer accountid;

    @Column(name = "surveyId")
    private Integer surveyid;

    @Column(name = "researchId")
    private Integer researchid;

    /**
     * `commited` TINYINT(1) NOT NULL COMMENT '是否已经考试完成（TRUE：完成，FALSE：未完成)',
     */
    private Boolean commited;

    private Date endtime;

    private Date starttime;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * @return accountsurveyId
     */
    public Integer getAccountsurveyid() {
        return accountsurveyid;
    }

    /**
     * @param accountsurveyid
     */
    public void setAccountsurveyid(Integer accountsurveyid) {
        this.accountsurveyid = accountsurveyid;
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
     * @return surveyId
     */
    public Integer getSurveyid() {
        return surveyid;
    }

    /**
     * @param surveyid
     */
    public void setSurveyid(Integer surveyid) {
        this.surveyid = surveyid;
    }

    /**
     * @return researchId
     */
    public Integer getResearchid() {
        return researchid;
    }

    /**
     * @param researchid
     */
    public void setResearchid(Integer researchid) {
        this.researchid = researchid;
    }

    /**
     * 获取`commited` TINYINT(1) NOT NULL COMMENT '是否已经考试完成（TRUE：完成，FALSE：未完成)',
     *
     * @return commited - `commited` TINYINT(1) NOT NULL COMMENT '是否已经考试完成（TRUE：完成，FALSE：未完成)',
     */
    public Boolean getCommited() {
        return commited;
    }

    /**
     * 设置`commited` TINYINT(1) NOT NULL COMMENT '是否已经考试完成（TRUE：完成，FALSE：未完成)',
     *
     * @param commited `commited` TINYINT(1) NOT NULL COMMENT '是否已经考试完成（TRUE：完成，FALSE：未完成)',
     */
    public void setCommited(Boolean commited) {
        this.commited = commited;
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
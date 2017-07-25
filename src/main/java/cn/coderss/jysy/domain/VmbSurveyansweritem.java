package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_surveyansweritem")
public class VmbSurveyansweritem {
    @Id
    @Column(name = "surveyansweritemId")
    private Integer surveyansweritemid;

    @Column(name = "answerId")
    private Integer answerid;

    @Column(name = "itemId")
    private Integer itemid;

    @Column(name = "accountsurveyId")
    private Integer accountsurveyid;

    /**
     * @return surveyansweritemId
     */
    public Integer getSurveyansweritemid() {
        return surveyansweritemid;
    }

    /**
     * @param surveyansweritemid
     */
    public void setSurveyansweritemid(Integer surveyansweritemid) {
        this.surveyansweritemid = surveyansweritemid;
    }

    /**
     * @return answerId
     */
    public Integer getAnswerid() {
        return answerid;
    }

    /**
     * @param answerid
     */
    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
    }

    /**
     * @return itemId
     */
    public Integer getItemid() {
        return itemid;
    }

    /**
     * @param itemid
     */
    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

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
}
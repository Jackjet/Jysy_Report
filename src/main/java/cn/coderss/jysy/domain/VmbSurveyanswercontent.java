package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_surveyanswercontent")
public class VmbSurveyanswercontent {
    @Id
    @Column(name = "surveyAnswerContentId")
    private Integer surveyanswercontentid;

    @Column(name = "answerId")
    private Integer answerid;

    private String content;

    @Column(name = "accountsurveyId")
    private Integer accountsurveyid;

    /**
     * @return surveyAnswerContentId
     */
    public Integer getSurveyanswercontentid() {
        return surveyanswercontentid;
    }

    /**
     * @param surveyanswercontentid
     */
    public void setSurveyanswercontentid(Integer surveyanswercontentid) {
        this.surveyanswercontentid = surveyanswercontentid;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
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
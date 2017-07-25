package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_surveyquestion")
public class VmbSurveyquestion {
    /**
     * 问卷题目Id

     */
    @Id
    @Column(name = "surveyquestionId")
    private Integer surveyquestionid;

    @Column(name = "questionId")
    private Integer questionid;

    @Column(name = "surveyId")
    private Integer surveyid;

    private Integer orderindex;

    /**
     * 获取问卷题目Id

     *
     * @return surveyquestionId - 问卷题目Id

     */
    public Integer getSurveyquestionid() {
        return surveyquestionid;
    }

    /**
     * 设置问卷题目Id

     *
     * @param surveyquestionid 问卷题目Id

     */
    public void setSurveyquestionid(Integer surveyquestionid) {
        this.surveyquestionid = surveyquestionid;
    }

    /**
     * @return questionId
     */
    public Integer getQuestionid() {
        return questionid;
    }

    /**
     * @param questionid
     */
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
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
     * @return orderindex
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }
}
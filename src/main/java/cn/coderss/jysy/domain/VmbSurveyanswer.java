package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_surveyanswer")
public class VmbSurveyanswer {
    /**
     * 答案Id
     */
    @Id
    @Column(name = "answerId")
    private Integer answerid;

    @Column(name = "accountsurveyId")
    private Integer accountsurveyid;

    @Column(name = "questionId")
    private Integer questionid;

    /**
     * 获取答案Id
     *
     * @return answerId - 答案Id
     */
    public Integer getAnswerid() {
        return answerid;
    }

    /**
     * 设置答案Id
     *
     * @param answerid 答案Id
     */
    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
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
}
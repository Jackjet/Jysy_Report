package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_answer")
public class VmbAnswer {
    @Id
    @Column(name = "answerId")
    private Integer answerid;

    @Column(name = "accountexamId")
    private Integer accountexamid;

    @Column(name = "questionId")
    private Integer questionid;

    private Integer recordeid;

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
     * @return accountexamId
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
     * @return recordeid
     */
    public Integer getRecordeid() {
        return recordeid;
    }

    /**
     * @param recordeid
     */
    public void setRecordeid(Integer recordeid) {
        this.recordeid = recordeid;
    }
}
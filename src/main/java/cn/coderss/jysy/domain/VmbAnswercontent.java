package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_answercontent")
public class VmbAnswercontent {
    @Id
    @Column(name = "answerContentId")
    private Integer answercontentid;

    private String content;

    @Column(name = "answerId")
    private Integer answerid;

    @Column(name = "accountExamId")
    private Integer accountexamid;

    private Integer recordeid;

    /**
     * @return answerContentId
     */
    public Integer getAnswercontentid() {
        return answercontentid;
    }

    /**
     * @param answercontentid
     */
    public void setAnswercontentid(Integer answercontentid) {
        this.answercontentid = answercontentid;
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
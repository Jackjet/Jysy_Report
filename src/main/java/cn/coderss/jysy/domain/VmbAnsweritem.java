package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_answeritem")
public class VmbAnsweritem {
    @Id
    @Column(name = "answerItemId")
    private Integer answeritemid;

    @Column(name = "itemId")
    private Integer itemid;

    @Column(name = "answerId")
    private Integer answerid;

    @Column(name = "accountExamId")
    private Integer accountexamid;

    private Integer recordeid;

    /**
     * @return answerItemId
     */
    public Integer getAnsweritemid() {
        return answeritemid;
    }

    /**
     * @param answeritemid
     */
    public void setAnsweritemid(Integer answeritemid) {
        this.answeritemid = answeritemid;
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
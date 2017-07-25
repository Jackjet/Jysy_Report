package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_questionitem")
public class VmbQuestionitem {
    @Id
    @Column(name = "itemId")
    private Integer itemid;

    /**
     * 答案对应的
     */
    @Column(name = "questionId")
    private Integer questionid;

    private String description;

    /**
     * 答案解释（如果是正确的则解释为何正确，如果是错误的则解释为何错误）
     */
    private String remark;

    /**
     * 是否正确答案
     */
    private Boolean correct;

    private Byte orderindex;

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
     * 获取答案对应的
     *
     * @return questionId - 答案对应的
     */
    public Integer getQuestionid() {
        return questionid;
    }

    /**
     * 设置答案对应的
     *
     * @param questionid 答案对应的
     */
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取答案解释（如果是正确的则解释为何正确，如果是错误的则解释为何错误）
     *
     * @return remark - 答案解释（如果是正确的则解释为何正确，如果是错误的则解释为何错误）
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置答案解释（如果是正确的则解释为何正确，如果是错误的则解释为何错误）
     *
     * @param remark 答案解释（如果是正确的则解释为何正确，如果是错误的则解释为何错误）
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否正确答案
     *
     * @return correct - 是否正确答案
     */
    public Boolean getCorrect() {
        return correct;
    }

    /**
     * 设置是否正确答案
     *
     * @param correct 是否正确答案
     */
    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    /**
     * @return orderindex
     */
    public Byte getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Byte orderindex) {
        this.orderindex = orderindex;
    }
}
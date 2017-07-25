package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_paperquestion")
public class VmbPaperquestion {
    @Id
    @Column(name = "paperQuestionId")
    private Integer paperquestionid;

    @Column(name = "paperId")
    private Integer paperid;

    @Column(name = "questionId")
    private Integer questionid;

    private Float weights;

    private Integer orderindex;

    /**
     * @return paperQuestionId
     */
    public Integer getPaperquestionid() {
        return paperquestionid;
    }

    /**
     * @param paperquestionid
     */
    public void setPaperquestionid(Integer paperquestionid) {
        this.paperquestionid = paperquestionid;
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
     * @return weights
     */
    public Float getWeights() {
        return weights;
    }

    /**
     * @param weights
     */
    public void setWeights(Float weights) {
        this.weights = weights;
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
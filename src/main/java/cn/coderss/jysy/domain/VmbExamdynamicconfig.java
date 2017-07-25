package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_examdynamicconfig")
public class VmbExamdynamicconfig {
    @Id
    @Column(name = "configID")
    private Integer configid;

    /**
     * 试卷ID
     */
    @Column(name = "paperId")
    private Integer paperid;

    /**
     * 题型，如果
     */
    private Integer quetype;

    private Float totalweights;

    private Float weights;

    /**
     * @return configID
     */
    public Integer getConfigid() {
        return configid;
    }

    /**
     * @param configid
     */
    public void setConfigid(Integer configid) {
        this.configid = configid;
    }

    /**
     * 获取试卷ID
     *
     * @return paperId - 试卷ID
     */
    public Integer getPaperid() {
        return paperid;
    }

    /**
     * 设置试卷ID
     *
     * @param paperid 试卷ID
     */
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    /**
     * 获取题型，如果
     *
     * @return quetype - 题型，如果
     */
    public Integer getQuetype() {
        return quetype;
    }

    /**
     * 设置题型，如果
     *
     * @param quetype 题型，如果
     */
    public void setQuetype(Integer quetype) {
        this.quetype = quetype;
    }

    /**
     * @return totalweights
     */
    public Float getTotalweights() {
        return totalweights;
    }

    /**
     * @param totalweights
     */
    public void setTotalweights(Float totalweights) {
        this.totalweights = totalweights;
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
}
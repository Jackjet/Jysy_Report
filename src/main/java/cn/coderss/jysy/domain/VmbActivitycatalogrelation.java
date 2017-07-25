package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_activitycatalogrelation")
public class VmbActivitycatalogrelation {
    @Id
    @Column(name = "relationId")
    private Integer relationid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "catalogId")
    private Integer catalogid;

    private Integer orderindex;

    /**
     * @return relationId
     */
    public Integer getRelationid() {
        return relationid;
    }

    /**
     * @param relationid
     */
    public void setRelationid(Integer relationid) {
        this.relationid = relationid;
    }

    /**
     * @return learningActivityId
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * @param learningactivityid
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * @return catalogId
     */
    public Integer getCatalogid() {
        return catalogid;
    }

    /**
     * @param catalogid
     */
    public void setCatalogid(Integer catalogid) {
        this.catalogid = catalogid;
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
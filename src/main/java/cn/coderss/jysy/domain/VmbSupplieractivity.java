package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_supplieractivity")
public class VmbSupplieractivity {
    @Id
    @Column(name = "supplierActivityId")
    private Integer supplieractivityid;

    @Column(name = "supplierId")
    private Integer supplierid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    /**
     * @return supplierActivityId
     */
    public Integer getSupplieractivityid() {
        return supplieractivityid;
    }

    /**
     * @param supplieractivityid
     */
    public void setSupplieractivityid(Integer supplieractivityid) {
        this.supplieractivityid = supplieractivityid;
    }

    /**
     * @return supplierId
     */
    public Integer getSupplierid() {
        return supplierid;
    }

    /**
     * @param supplierid
     */
    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
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
}
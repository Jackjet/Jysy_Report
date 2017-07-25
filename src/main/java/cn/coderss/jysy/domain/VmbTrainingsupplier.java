package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_trainingsupplier")
public class VmbTrainingsupplier {
    @Id
    @Column(name = "trainingSupplierId")
    private Integer trainingsupplierid;

    @Column(name = "supplierId")
    private Integer supplierid;

    @Column(name = "trainingSolutionId")
    private Integer trainingsolutionid;

    /**
     * @return trainingSupplierId
     */
    public Integer getTrainingsupplierid() {
        return trainingsupplierid;
    }

    /**
     * @param trainingsupplierid
     */
    public void setTrainingsupplierid(Integer trainingsupplierid) {
        this.trainingsupplierid = trainingsupplierid;
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
     * @return trainingSolutionId
     */
    public Integer getTrainingsolutionid() {
        return trainingsolutionid;
    }

    /**
     * @param trainingsolutionid
     */
    public void setTrainingsolutionid(Integer trainingsolutionid) {
        this.trainingsolutionid = trainingsolutionid;
    }
}
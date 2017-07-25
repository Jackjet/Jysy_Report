package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_exampermit")
public class VmbExampermit {
    private Integer exampermitid;

    @Column(name = "examinationId")
    private Integer examinationid;

    /**
     * @return exampermitid
     */
    public Integer getExampermitid() {
        return exampermitid;
    }

    /**
     * @param exampermitid
     */
    public void setExampermitid(Integer exampermitid) {
        this.exampermitid = exampermitid;
    }

    /**
     * @return examinationId
     */
    public Integer getExaminationid() {
        return examinationid;
    }

    /**
     * @param examinationid
     */
    public void setExaminationid(Integer examinationid) {
        this.examinationid = examinationid;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_sequece")
public class VmbSequece {
    @Id
    @Column(name = "sequeceId")
    private Integer sequeceid;

    @Column(name = "objectId")
    private Integer objectid;

    private Integer seqval;

    /**
     * @return sequeceId
     */
    public Integer getSequeceid() {
        return sequeceid;
    }

    /**
     * @param sequeceid
     */
    public void setSequeceid(Integer sequeceid) {
        this.sequeceid = sequeceid;
    }

    /**
     * @return objectId
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * @param objectid
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * @return seqval
     */
    public Integer getSeqval() {
        return seqval;
    }

    /**
     * @param seqval
     */
    public void setSeqval(Integer seqval) {
        this.seqval = seqval;
    }
}
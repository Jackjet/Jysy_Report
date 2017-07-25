package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_paperorderindex")
public class VmbPaperorderindex {
    @Id
    @Column(name = "paperorderindexId")
    private Integer paperorderindexid;

    private Integer quetype;

    private Integer orderindex;

    @Column(name = "paperId")
    private Integer paperid;

    /**
     * @return paperorderindexId
     */
    public Integer getPaperorderindexid() {
        return paperorderindexid;
    }

    /**
     * @param paperorderindexid
     */
    public void setPaperorderindexid(Integer paperorderindexid) {
        this.paperorderindexid = paperorderindexid;
    }

    /**
     * @return quetype
     */
    public Integer getQuetype() {
        return quetype;
    }

    /**
     * @param quetype
     */
    public void setQuetype(Integer quetype) {
        this.quetype = quetype;
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
}
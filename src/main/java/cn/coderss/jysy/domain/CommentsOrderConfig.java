package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "comments_order_config")
public class CommentsOrderConfig {
    @Id
    private Integer configid;

    private Integer enterpriseid;

    private Integer collegeid;

    private Integer orderindex;

    /**
     * @return configid
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
     * @return enterpriseid
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * @return collegeid
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * @param collegeid
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
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
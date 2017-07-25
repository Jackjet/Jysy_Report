package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_enterprisetag")
public class VmbEnterprisetag {
    @Id
    private Integer enterprisetagid;

    private Integer enterpriseid;

    private Integer microcoursetagid;

    @Column(name = "orderIndex")
    private Integer orderindex;

    /**
     * 是否启用
     */
    private Integer states;

    /**
     * @return enterprisetagid
     */
    public Integer getEnterprisetagid() {
        return enterprisetagid;
    }

    /**
     * @param enterprisetagid
     */
    public void setEnterprisetagid(Integer enterprisetagid) {
        this.enterprisetagid = enterprisetagid;
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
     * @return microcoursetagid
     */
    public Integer getMicrocoursetagid() {
        return microcoursetagid;
    }

    /**
     * @param microcoursetagid
     */
    public void setMicrocoursetagid(Integer microcoursetagid) {
        this.microcoursetagid = microcoursetagid;
    }

    /**
     * @return orderIndex
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
     * 获取是否启用
     *
     * @return states - 是否启用
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置是否启用
     *
     * @param states 是否启用
     */
    public void setStates(Integer states) {
        this.states = states;
    }
}
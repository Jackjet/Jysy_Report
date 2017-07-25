package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_org")
public class VmbOrg {
    /**
     * 部门/机构
     */
    @Id
    @Column(name = "orgId")
    private Integer orgid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 部门名称
     */
    private String name;

    @Column(name = "parentorgId")
    private Integer parentorgid;

    private String orgcode;

    private Integer provinceid;

    private Integer cityid;

    private Integer countyid;

    private Integer orderindex;

    /**
     * 获取部门/机构
     *
     * @return orgId - 部门/机构
     */
    public Integer getOrgid() {
        return orgid;
    }

    /**
     * 设置部门/机构
     *
     * @param orgid 部门/机构
     */
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    /**
     * @return enterpriseId
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
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return parentorgId
     */
    public Integer getParentorgid() {
        return parentorgid;
    }

    /**
     * @param parentorgid
     */
    public void setParentorgid(Integer parentorgid) {
        this.parentorgid = parentorgid;
    }

    /**
     * @return orgcode
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * @param orgcode
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * @return provinceid
     */
    public Integer getProvinceid() {
        return provinceid;
    }

    /**
     * @param provinceid
     */
    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    /**
     * @return cityid
     */
    public Integer getCityid() {
        return cityid;
    }

    /**
     * @param cityid
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    /**
     * @return countyid
     */
    public Integer getCountyid() {
        return countyid;
    }

    /**
     * @param countyid
     */
    public void setCountyid(Integer countyid) {
        this.countyid = countyid;
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
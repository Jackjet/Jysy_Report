package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_org_info")
public class CacheOrgInfo {
    /**
     * org_id
     */
    @Id
    private Integer orgid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    private String name;

    private String orgcode;

    @Column(name = "code_path")
    private String codePath;

    @Column(name = "id_path")
    private String idPath;

    @Column(name = "name_path")
    private String namePath;

    @Column(name = "parentorgId")
    private Integer parentorgid;

    private Integer provinceid;

    private Integer cityid;

    private Integer countyid;

    private Integer orderindex;

    /**
     * 获取org_id
     *
     * @return orgid - org_id
     */
    public Integer getOrgid() {
        return orgid;
    }

    /**
     * 设置org_id
     *
     * @param orgid org_id
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return code_path
     */
    public String getCodePath() {
        return codePath;
    }

    /**
     * @param codePath
     */
    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    /**
     * @return id_path
     */
    public String getIdPath() {
        return idPath;
    }

    /**
     * @param idPath
     */
    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    /**
     * @return name_path
     */
    public String getNamePath() {
        return namePath;
    }

    /**
     * @param namePath
     */
    public void setNamePath(String namePath) {
        this.namePath = namePath;
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
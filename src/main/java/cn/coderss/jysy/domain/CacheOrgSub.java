package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_org_sub")
public class CacheOrgSub {
    @Id
    private Integer primaryid;

    private Integer orgid;

    @Column(name = "sub_org_id")
    private Integer subOrgId;

    /**
     * @return primaryid
     */
    public Integer getPrimaryid() {
        return primaryid;
    }

    /**
     * @param primaryid
     */
    public void setPrimaryid(Integer primaryid) {
        this.primaryid = primaryid;
    }

    /**
     * @return orgid
     */
    public Integer getOrgid() {
        return orgid;
    }

    /**
     * @param orgid
     */
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    /**
     * @return sub_org_id
     */
    public Integer getSubOrgId() {
        return subOrgId;
    }

    /**
     * @param subOrgId
     */
    public void setSubOrgId(Integer subOrgId) {
        this.subOrgId = subOrgId;
    }
}
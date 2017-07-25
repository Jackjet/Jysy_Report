package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_region")
public class VmbRegion {
    @Id
    private Integer regionid;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "parent_id")
    private Integer parentId;

    private Integer level;

    private String code;

    /**
     * @return regionid
     */
    public Integer getRegionid() {
        return regionid;
    }

    /**
     * @param regionid
     */
    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    /**
     * @return region_name
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * @param regionName
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
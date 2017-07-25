package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_permissiongroup")
public class VmbPermissiongroup {
    @Id
    @Column(name = "permissiongroupId")
    private Integer permissiongroupid;

    private String name;

    private String code;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * @return permissiongroupId
     */
    public Integer getPermissiongroupid() {
        return permissiongroupid;
    }

    /**
     * @param permissiongroupid
     */
    public void setPermissiongroupid(Integer permissiongroupid) {
        this.permissiongroupid = permissiongroupid;
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
}
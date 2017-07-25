package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_permissionrel")
public class VmbPermissionrel {
    @Id
    @Column(name = "relId")
    private Integer relid;

    @Column(name = "permissionId")
    private Integer permissionid;

    @Column(name = "permissionGroupId")
    private Integer permissiongroupid;

    /**
     * @return relId
     */
    public Integer getRelid() {
        return relid;
    }

    /**
     * @param relid
     */
    public void setRelid(Integer relid) {
        this.relid = relid;
    }

    /**
     * @return permissionId
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * @param permissionid
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    /**
     * @return permissionGroupId
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
}
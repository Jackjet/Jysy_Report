package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "bcm_group")
public class BcmGroup {
    @Id
    private Integer groupid;

    private String name;

    private Integer activityid;

    /**
     * @return groupid
     */
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * @param groupid
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
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
     * @return activityid
     */
    public Integer getActivityid() {
        return activityid;
    }

    /**
     * @param activityid
     */
    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }
}
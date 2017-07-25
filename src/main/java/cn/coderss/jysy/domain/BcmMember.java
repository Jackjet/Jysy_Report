package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "bcm_member")
public class BcmMember {
    @Id
    private Integer gmemberid;

    private Integer accountid;

    private Integer groupid;

    private Integer activityid;

    /**
     * @return gmemberid
     */
    public Integer getGmemberid() {
        return gmemberid;
    }

    /**
     * @param gmemberid
     */
    public void setGmemberid(Integer gmemberid) {
        this.gmemberid = gmemberid;
    }

    /**
     * @return accountid
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

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
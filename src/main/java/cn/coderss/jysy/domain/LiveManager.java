package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "live_manager")
public class LiveManager {
    @Id
    private Integer managerid;

    @Column(name = "live_roomid")
    private Integer liveRoomid;

    private Integer accountid;

    private Integer collegeid;

    private Integer enterpriseid;

    /**
     * @return managerid
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * @param managerid
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    /**
     * @return live_roomid
     */
    public Integer getLiveRoomid() {
        return liveRoomid;
    }

    /**
     * @param liveRoomid
     */
    public void setLiveRoomid(Integer liveRoomid) {
        this.liveRoomid = liveRoomid;
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
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "live_room_orgdistrib")
public class LiveRoomOrgdistrib {
    @Id
    @Column(name = "org_distribid")
    private Integer orgDistribid;

    private Integer orgid;

    private Date createtime;

    private Integer valid;

    @Column(name = "live_roomid")
    private Integer liveRoomid;

    private Integer collegeid;

    private Integer enterpriseid;

    /**
     * @return org_distribid
     */
    public Integer getOrgDistribid() {
        return orgDistribid;
    }

    /**
     * @param orgDistribid
     */
    public void setOrgDistribid(Integer orgDistribid) {
        this.orgDistribid = orgDistribid;
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
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
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
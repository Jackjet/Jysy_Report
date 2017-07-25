package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "live_room_memberdestrib")
public class LiveRoomMemberdestrib {
    @Id
    @Column(name = "member_diestirib_id")
    private Integer memberDiestiribId;

    private Integer accountid;

    private Date createtime;

    private Integer valid;

    @Column(name = "live_roomid")
    private Integer liveRoomid;

    private Integer collegeid;

    private Integer enterpriseid;

    /**
     * @return member_diestirib_id
     */
    public Integer getMemberDiestiribId() {
        return memberDiestiribId;
    }

    /**
     * @param memberDiestiribId
     */
    public void setMemberDiestiribId(Integer memberDiestiribId) {
        this.memberDiestiribId = memberDiestiribId;
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
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "live_replay_recorde")
public class LiveReplayRecorde {
    @Id
    private Integer recordeid;

    private Integer scheduleid;

    @Column(name = "live_roomid")
    private Integer liveRoomid;

    private Integer accountid;

    private Date starttime;

    private Date endtime;

    private Integer valid;

    private String terminal;

    private Integer duration;

    private String ip;

    private Integer enterpriseid;

    private Integer collegeid;

    /**
     * @return recordeid
     */
    public Integer getRecordeid() {
        return recordeid;
    }

    /**
     * @param recordeid
     */
    public void setRecordeid(Integer recordeid) {
        this.recordeid = recordeid;
    }

    /**
     * @return scheduleid
     */
    public Integer getScheduleid() {
        return scheduleid;
    }

    /**
     * @param scheduleid
     */
    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
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
     * @return starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * @param starttime
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * @return endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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
     * @return terminal
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * @param terminal
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
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
}
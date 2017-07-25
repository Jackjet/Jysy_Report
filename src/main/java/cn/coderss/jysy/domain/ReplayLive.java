package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "replay_live")
public class ReplayLive {
    @Id
    private Integer replayid;

    private String vid;

    private Integer duration;

    private Date starttime;

    private Integer scheduleid;

    @Column(name = "live_roomid")
    private Integer liveRoomid;

    private String url;

    private String name;

    private Date endtime;

    private Integer states;

    /**
     * @return replayid
     */
    public Integer getReplayid() {
        return replayid;
    }

    /**
     * @param replayid
     */
    public void setReplayid(Integer replayid) {
        this.replayid = replayid;
    }

    /**
     * @return vid
     */
    public String getVid() {
        return vid;
    }

    /**
     * @param vid
     */
    public void setVid(String vid) {
        this.vid = vid;
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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
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
     * @return states
     */
    public Integer getStates() {
        return states;
    }

    /**
     * @param states
     */
    public void setStates(Integer states) {
        this.states = states;
    }
}
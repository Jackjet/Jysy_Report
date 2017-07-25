package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rpt_polyv_log")
public class RptPolyvLog {
    @Id
    private Integer logid;

    private Integer videoid;

    private Date logdate;

    @Column(name = "play_duration")
    private Integer playDuration;

    @Column(name = "stay_duration")
    private Integer stayDuration;

    @Column(name = "current_times")
    private Integer currentTimes;

    private Integer duration;

    @Column(name = "flow_size")
    private Integer flowSize;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "created_time")
    private Integer createdTime;

    /**
     * @return logid
     */
    public Integer getLogid() {
        return logid;
    }

    /**
     * @param logid
     */
    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    /**
     * @return videoid
     */
    public Integer getVideoid() {
        return videoid;
    }

    /**
     * @param videoid
     */
    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    /**
     * @return logdate
     */
    public Date getLogdate() {
        return logdate;
    }

    /**
     * @param logdate
     */
    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    /**
     * @return play_duration
     */
    public Integer getPlayDuration() {
        return playDuration;
    }

    /**
     * @param playDuration
     */
    public void setPlayDuration(Integer playDuration) {
        this.playDuration = playDuration;
    }

    /**
     * @return stay_duration
     */
    public Integer getStayDuration() {
        return stayDuration;
    }

    /**
     * @param stayDuration
     */
    public void setStayDuration(Integer stayDuration) {
        this.stayDuration = stayDuration;
    }

    /**
     * @return current_times
     */
    public Integer getCurrentTimes() {
        return currentTimes;
    }

    /**
     * @param currentTimes
     */
    public void setCurrentTimes(Integer currentTimes) {
        this.currentTimes = currentTimes;
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
     * @return flow_size
     */
    public Integer getFlowSize() {
        return flowSize;
    }

    /**
     * @param flowSize
     */
    public void setFlowSize(Integer flowSize) {
        this.flowSize = flowSize;
    }

    /**
     * @return ip_address
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return created_time
     */
    public Integer getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_eventlog")
public class SysEventlog {
    @Id
    private Integer eventid;

    private Date starttime;

    private Date endtime;

    private Integer status;

    private String eventype;

    /**
     * @return eventid
     */
    public Integer getEventid() {
        return eventid;
    }

    /**
     * @param eventid
     */
    public void setEventid(Integer eventid) {
        this.eventid = eventid;
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
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return eventype
     */
    public String getEventype() {
        return eventype;
    }

    /**
     * @param eventype
     */
    public void setEventype(String eventype) {
        this.eventype = eventype;
    }
}
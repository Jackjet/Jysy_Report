package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_scorm_error_recorde")
public class VmbScormErrorRecorde {
    @Id
    private Integer errorid;

    private Integer recordeid;

    private Integer activityid;

    private Integer duration;

    private Date createtime;

    private String msg;

    private String jsondata;

    /**
     * @return errorid
     */
    public Integer getErrorid() {
        return errorid;
    }

    /**
     * @param errorid
     */
    public void setErrorid(Integer errorid) {
        this.errorid = errorid;
    }

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
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return jsondata
     */
    public String getJsondata() {
        return jsondata;
    }

    /**
     * @param jsondata
     */
    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }
}
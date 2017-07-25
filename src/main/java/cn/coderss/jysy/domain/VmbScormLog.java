package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_scorm_log")
public class VmbScormLog {
    @Id
    private Integer logid;

    private Integer accountid;

    private Integer scormid;

    private Integer learningactivityid;

    private Integer recordeid;

    private Date createtime;

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
     * @return scormid
     */
    public Integer getScormid() {
        return scormid;
    }

    /**
     * @param scormid
     */
    public void setScormid(Integer scormid) {
        this.scormid = scormid;
    }

    /**
     * @return learningactivityid
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * @param learningactivityid
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
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
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cache_fd_ac_lear")
public class CacheFdAcLear {
    @Id
    private Integer id;

    private Integer accountid;

    private Integer learningactivityid;

    @Column(name = "cer_code")
    private String cerCode;

    @Column(name = "cer_get_time")
    private Date cerGetTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return cer_code
     */
    public String getCerCode() {
        return cerCode;
    }

    /**
     * @param cerCode
     */
    public void setCerCode(String cerCode) {
        this.cerCode = cerCode;
    }

    /**
     * @return cer_get_time
     */
    public Date getCerGetTime() {
        return cerGetTime;
    }

    /**
     * @param cerGetTime
     */
    public void setCerGetTime(Date cerGetTime) {
        this.cerGetTime = cerGetTime;
    }
}
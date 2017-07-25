package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_error_recorde")
public class VmbErrorRecorde {
    /**
     * LONGTEXT
     */
    @Id
    private Integer recordeid;

    private Integer learningactivityid;

    private Integer accountid;

    private Date createtime;

    private Integer collegeid;

    private Integer enterpriseid;

    private Float score;

    private Date starttime;

    private String jsondata;

    /**
     * 获取LONGTEXT
     *
     * @return recordeid - LONGTEXT
     */
    public Integer getRecordeid() {
        return recordeid;
    }

    /**
     * 设置LONGTEXT
     *
     * @param recordeid LONGTEXT
     */
    public void setRecordeid(Integer recordeid) {
        this.recordeid = recordeid;
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

    /**
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
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
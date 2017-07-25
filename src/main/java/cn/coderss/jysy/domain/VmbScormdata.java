package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_scormdata")
public class VmbScormdata {
    @Id
    private Integer scormdataid;

    /**
     * scorm的ID值
     */
    private Integer scormid;

    private Integer accountid;

    private Integer learningactivityid;

    /**
     * jsondata的数据
     */
    private String jsondata;

    /**
     * @return scormdataid
     */
    public Integer getScormdataid() {
        return scormdataid;
    }

    /**
     * @param scormdataid
     */
    public void setScormdataid(Integer scormdataid) {
        this.scormdataid = scormdataid;
    }

    /**
     * 获取scorm的ID值
     *
     * @return scormid - scorm的ID值
     */
    public Integer getScormid() {
        return scormid;
    }

    /**
     * 设置scorm的ID值
     *
     * @param scormid scorm的ID值
     */
    public void setScormid(Integer scormid) {
        this.scormid = scormid;
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
     * 获取jsondata的数据
     *
     * @return jsondata - jsondata的数据
     */
    public String getJsondata() {
        return jsondata;
    }

    /**
     * 设置jsondata的数据
     *
     * @param jsondata jsondata的数据
     */
    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }
}
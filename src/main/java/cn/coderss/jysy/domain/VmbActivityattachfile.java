package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_activityattachfile")
public class VmbActivityattachfile {
    /**
     * 学习活动id
     */
    @Id
    private Integer learningactivityid;

    /**
     * 学院id
     */
    @Id
    private Integer collegeid;

    /**
     * url地址
     */
    private String url;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 创建人员id
     */
    private Integer createaccountid;

    /**
     * 获取学习活动id
     *
     * @return learningactivityid - 学习活动id
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置学习活动id
     *
     * @param learningactivityid 学习活动id
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取学院id
     *
     * @return collegeid - 学院id
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * 设置学院id
     *
     * @param collegeid 学院id
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * 获取url地址
     *
     * @return url - url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url地址
     *
     * @param url url地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取创建人员id
     *
     * @return createaccountid - 创建人员id
     */
    public Integer getCreateaccountid() {
        return createaccountid;
    }

    /**
     * 设置创建人员id
     *
     * @param createaccountid 创建人员id
     */
    public void setCreateaccountid(Integer createaccountid) {
        this.createaccountid = createaccountid;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_wechatmp")
public class VmbWechatmp {
    @Id
    @Column(name = "wechatmpId")
    private Integer wechatmpid;

    private String name;

    /**
     * 微信公众号原始Id
     */
    @Column(name = "originalId")
    private String originalid;

    @Column(name = "APPId")
    private String appid;

    @Column(name = "APPSecret")
    private String appsecret;

    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * 企业应用ID
     */
    private Integer agentid;

    /**
     * 微信号类型（1=企业号，2=公众号，3=服务号，4=个人微信）
     */
    @Column(name = "AppType")
    private Integer apptype;

    private String wechatdata;

    private Integer islogin;

    private Integer status;

    /**
     * @return wechatmpId
     */
    public Integer getWechatmpid() {
        return wechatmpid;
    }

    /**
     * @param wechatmpid
     */
    public void setWechatmpid(Integer wechatmpid) {
        this.wechatmpid = wechatmpid;
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
     * 获取微信公众号原始Id
     *
     * @return originalId - 微信公众号原始Id
     */
    public String getOriginalid() {
        return originalid;
    }

    /**
     * 设置微信公众号原始Id
     *
     * @param originalid 微信公众号原始Id
     */
    public void setOriginalid(String originalid) {
        this.originalid = originalid;
    }

    /**
     * @return APPId
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return APPSecret
     */
    public String getAppsecret() {
        return appsecret;
    }

    /**
     * @param appsecret
     */
    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    /**
     * @return collegeId
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
     * 获取企业应用ID
     *
     * @return agentid - 企业应用ID
     */
    public Integer getAgentid() {
        return agentid;
    }

    /**
     * 设置企业应用ID
     *
     * @param agentid 企业应用ID
     */
    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    /**
     * 获取微信号类型（1=企业号，2=公众号，3=服务号，4=个人微信）
     *
     * @return AppType - 微信号类型（1=企业号，2=公众号，3=服务号，4=个人微信）
     */
    public Integer getApptype() {
        return apptype;
    }

    /**
     * 设置微信号类型（1=企业号，2=公众号，3=服务号，4=个人微信）
     *
     * @param apptype 微信号类型（1=企业号，2=公众号，3=服务号，4=个人微信）
     */
    public void setApptype(Integer apptype) {
        this.apptype = apptype;
    }

    /**
     * @return wechatdata
     */
    public String getWechatdata() {
        return wechatdata;
    }

    /**
     * @param wechatdata
     */
    public void setWechatdata(String wechatdata) {
        this.wechatdata = wechatdata;
    }

    /**
     * @return islogin
     */
    public Integer getIslogin() {
        return islogin;
    }

    /**
     * @param islogin
     */
    public void setIslogin(Integer islogin) {
        this.islogin = islogin;
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
}
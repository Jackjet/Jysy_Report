package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wechat_config")
public class WechatConfig {
    @Id
    private String appid;

    @Column(name = "svc_appid")
    private String svcAppid;

    @Column(name = "svc_appsecret")
    private String svcAppsecret;

    private String name;

    private Date createtime;

    /**
     * @return appid
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
     * @return svc_appid
     */
    public String getSvcAppid() {
        return svcAppid;
    }

    /**
     * @param svcAppid
     */
    public void setSvcAppid(String svcAppid) {
        this.svcAppid = svcAppid;
    }

    /**
     * @return svc_appsecret
     */
    public String getSvcAppsecret() {
        return svcAppsecret;
    }

    /**
     * @param svcAppsecret
     */
    public void setSvcAppsecret(String svcAppsecret) {
        this.svcAppsecret = svcAppsecret;
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
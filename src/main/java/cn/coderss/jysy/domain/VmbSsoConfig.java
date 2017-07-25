package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_sso_config")
public class VmbSsoConfig {
    @Id
    private Integer configid;

    private Integer enterpriseid;

    private Integer collegeid;

    private String appid;

    private String appsecret;

    /**
     * @return configid
     */
    public Integer getConfigid() {
        return configid;
    }

    /**
     * @param configid
     */
    public void setConfigid(Integer configid) {
        this.configid = configid;
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
     * @return appsecret
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
}
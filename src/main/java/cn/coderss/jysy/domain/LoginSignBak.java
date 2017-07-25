package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "login_sign_bak")
public class LoginSignBak {
    @Id
    private String appid;

    @Column(name = "app_secret")
    private String appSecret;

    private Integer collegeid;

    private Integer enterpriseid;

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
     * @return app_secret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * @param appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
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
}
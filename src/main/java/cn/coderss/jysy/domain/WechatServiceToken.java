package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wechat_service_token")
public class WechatServiceToken {
    @Id
    private Integer tokenid;

    @Column(name = "wechat_service_token")
    private String wechatServiceToken;

    private Integer accountid;

    @Column(name = "auto_login")
    private Integer autoLogin;

    private Date createtime;

    private String openid;

    /**
     * @return tokenid
     */
    public Integer getTokenid() {
        return tokenid;
    }

    /**
     * @param tokenid
     */
    public void setTokenid(Integer tokenid) {
        this.tokenid = tokenid;
    }

    /**
     * @return wechat_service_token
     */
    public String getWechatServiceToken() {
        return wechatServiceToken;
    }

    /**
     * @param wechatServiceToken
     */
    public void setWechatServiceToken(String wechatServiceToken) {
        this.wechatServiceToken = wechatServiceToken;
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
     * @return auto_login
     */
    public Integer getAutoLogin() {
        return autoLogin;
    }

    /**
     * @param autoLogin
     */
    public void setAutoLogin(Integer autoLogin) {
        this.autoLogin = autoLogin;
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
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
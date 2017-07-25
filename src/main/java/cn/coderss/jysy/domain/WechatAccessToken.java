package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wechat_access_token")
public class WechatAccessToken {
    @Id
    @Column(name = "access_tokenid")
    private Integer accessTokenid;

    @Column(name = "wechat_appid")
    private String wechatAppid;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "expires_in")
    private Integer expiresIn;

    private Date createtime;

    private String openid;

    /**
     * @return access_tokenid
     */
    public Integer getAccessTokenid() {
        return accessTokenid;
    }

    /**
     * @param accessTokenid
     */
    public void setAccessTokenid(Integer accessTokenid) {
        this.accessTokenid = accessTokenid;
    }

    /**
     * @return wechat_appid
     */
    public String getWechatAppid() {
        return wechatAppid;
    }

    /**
     * @param wechatAppid
     */
    public void setWechatAppid(String wechatAppid) {
        this.wechatAppid = wechatAppid;
    }

    /**
     * @return access_token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return expires_in
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * @param expiresIn
     */
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
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
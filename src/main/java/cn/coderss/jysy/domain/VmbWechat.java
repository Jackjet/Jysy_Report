package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_wechat")
public class VmbWechat {
    @Id
    @Column(name = "wechatId")
    private Integer wechatid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 城市
     */
    private String city;

    /**
     * 国家
     */
    private String county;

    /**
     * 省份
     */
    private String province;

    /**
     * 微信用户的openid
     */
    private String openid;

    /**
     * 微信用户关注公众号的时间
     */
    private Date focustime;

    /**
     * 微信用户客户端语言

     */
    private String language;

    /**
     * 微信用户头像
     */
    private String headimgurl;

    /**
     * 微信昵称
     */
    private String nickname;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "access_token_expirestime")
    private Date accessTokenExpirestime;

    /**
     * 性别
     */
    private String sex;

    /**
     * @return wechatId
     */
    public Integer getWechatid() {
        return wechatid;
    }

    /**
     * @param wechatid
     */
    public void setWechatid(Integer wechatid) {
        this.wechatid = wechatid;
    }

    /**
     * @return accountId
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
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取国家
     *
     * @return county - 国家
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置国家
     *
     * @param county 国家
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取微信用户的openid
     *
     * @return openid - 微信用户的openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信用户的openid
     *
     * @param openid 微信用户的openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取微信用户关注公众号的时间
     *
     * @return focustime - 微信用户关注公众号的时间
     */
    public Date getFocustime() {
        return focustime;
    }

    /**
     * 设置微信用户关注公众号的时间
     *
     * @param focustime 微信用户关注公众号的时间
     */
    public void setFocustime(Date focustime) {
        this.focustime = focustime;
    }

    /**
     * 获取微信用户客户端语言

     *
     * @return language - 微信用户客户端语言

     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置微信用户客户端语言

     *
     * @param language 微信用户客户端语言

     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取微信用户头像
     *
     * @return headimgurl - 微信用户头像
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置微信用户头像
     *
     * @param headimgurl 微信用户头像
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * 获取微信昵称
     *
     * @return nickname - 微信昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置微信昵称
     *
     * @param nickname 微信昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * @return access_token_expirestime
     */
    public Date getAccessTokenExpirestime() {
        return accessTokenExpirestime;
    }

    /**
     * @param accessTokenExpirestime
     */
    public void setAccessTokenExpirestime(Date accessTokenExpirestime) {
        this.accessTokenExpirestime = accessTokenExpirestime;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
}
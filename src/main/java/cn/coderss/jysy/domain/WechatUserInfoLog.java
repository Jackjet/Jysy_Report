package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wechat_user_info_log")
public class WechatUserInfoLog {
    @Id
    private Integer logid;

    /**
     * wechat openid
     */
    private String openid;

    @Column(name = "accountId")
    private Integer accountid;

    private String city;

    private String county;

    private String province;

    /**
     * 关注微信号时间
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

    private String sex;

    private Date createtime;

    private String appid;

    /**
     * @return logid
     */
    public Integer getLogid() {
        return logid;
    }

    /**
     * @param logid
     */
    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    /**
     * 获取wechat openid
     *
     * @return openid - wechat openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置wechat openid
     *
     * @param openid wechat openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
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
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取关注微信号时间
     *
     * @return focustime - 关注微信号时间
     */
    public Date getFocustime() {
        return focustime;
    }

    /**
     * 设置关注微信号时间
     *
     * @param focustime 关注微信号时间
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
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
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
}
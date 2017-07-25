package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_shareinfo")
public class VmbShareinfo {
    @Id
    @Column(name = "shareId")
    private Integer shareid;

    /**
     * 被分享的Url
     */
    @Column(name = "shareUrl")
    private String shareurl;

    /**
     * 分享到的目标Url
     */
    @Column(name = "destUrl")
    private String desturl;

    /**
     * 分享者的微信openid
     */
    private String openid;

    /**
     * 分享者的账户Id
     */
    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 转发类型：friend，friendcircle，qqweibo，iOS，other
     */
    private String sharetype;

    /**
     * 被转发对象类型：course、catalog、activity
     */
    private String shareobject;

    /**
     * 被转发对象Id
     */
    @Column(name = "objectId")
    private Integer objectid;

    /**
     * 分享者的微信昵称
     */
    private String nickname;

    /**
     * 分享时间
     */
    private Date sharetime;

    /**
     * @return shareId
     */
    public Integer getShareid() {
        return shareid;
    }

    /**
     * @param shareid
     */
    public void setShareid(Integer shareid) {
        this.shareid = shareid;
    }

    /**
     * 获取被分享的Url
     *
     * @return shareUrl - 被分享的Url
     */
    public String getShareurl() {
        return shareurl;
    }

    /**
     * 设置被分享的Url
     *
     * @param shareurl 被分享的Url
     */
    public void setShareurl(String shareurl) {
        this.shareurl = shareurl;
    }

    /**
     * 获取分享到的目标Url
     *
     * @return destUrl - 分享到的目标Url
     */
    public String getDesturl() {
        return desturl;
    }

    /**
     * 设置分享到的目标Url
     *
     * @param desturl 分享到的目标Url
     */
    public void setDesturl(String desturl) {
        this.desturl = desturl;
    }

    /**
     * 获取分享者的微信openid
     *
     * @return openid - 分享者的微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置分享者的微信openid
     *
     * @param openid 分享者的微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取分享者的账户Id
     *
     * @return accountId - 分享者的账户Id
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置分享者的账户Id
     *
     * @param accountid 分享者的账户Id
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取转发类型：friend，friendcircle，qqweibo，iOS，other
     *
     * @return sharetype - 转发类型：friend，friendcircle，qqweibo，iOS，other
     */
    public String getSharetype() {
        return sharetype;
    }

    /**
     * 设置转发类型：friend，friendcircle，qqweibo，iOS，other
     *
     * @param sharetype 转发类型：friend，friendcircle，qqweibo，iOS，other
     */
    public void setSharetype(String sharetype) {
        this.sharetype = sharetype;
    }

    /**
     * 获取被转发对象类型：course、catalog、activity
     *
     * @return shareobject - 被转发对象类型：course、catalog、activity
     */
    public String getShareobject() {
        return shareobject;
    }

    /**
     * 设置被转发对象类型：course、catalog、activity
     *
     * @param shareobject 被转发对象类型：course、catalog、activity
     */
    public void setShareobject(String shareobject) {
        this.shareobject = shareobject;
    }

    /**
     * 获取被转发对象Id
     *
     * @return objectId - 被转发对象Id
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * 设置被转发对象Id
     *
     * @param objectid 被转发对象Id
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * 获取分享者的微信昵称
     *
     * @return nickname - 分享者的微信昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置分享者的微信昵称
     *
     * @param nickname 分享者的微信昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取分享时间
     *
     * @return sharetime - 分享时间
     */
    public Date getSharetime() {
        return sharetime;
    }

    /**
     * 设置分享时间
     *
     * @param sharetime 分享时间
     */
    public void setSharetime(Date sharetime) {
        this.sharetime = sharetime;
    }
}
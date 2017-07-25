package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_message")
public class VmbMessage {
    @Id
    @Column(name = "messageId")
    private Integer messageid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 创建者
     */
    private String createuser;

    /**
     * 学院Id
     */
    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * 是否发送所有人
     */
    private Boolean publishall;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    private Date sendtime;

    private Integer states;

    private Integer sendtype;

    private Integer messagetype;

    private Integer top;

    @Column(name = "image_url")
    private String imageUrl;

    /**
     * @return messageId
     */
    public Integer getMessageid() {
        return messageid;
    }

    /**
     * @param messageid
     */
    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
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
     * 获取创建者
     *
     * @return createuser - 创建者
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * 设置创建者
     *
     * @param createuser 创建者
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    /**
     * 获取学院Id
     *
     * @return collegeId - 学院Id
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * 设置学院Id
     *
     * @param collegeid 学院Id
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * 获取是否发送所有人
     *
     * @return publishall - 是否发送所有人
     */
    public Boolean getPublishall() {
        return publishall;
    }

    /**
     * 设置是否发送所有人
     *
     * @param publishall 是否发送所有人
     */
    public void setPublishall(Boolean publishall) {
        this.publishall = publishall;
    }

    /**
     * @return enterpriseId
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
     * @return sendtime
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * @param sendtime
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    /**
     * @return states
     */
    public Integer getStates() {
        return states;
    }

    /**
     * @param states
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * @return sendtype
     */
    public Integer getSendtype() {
        return sendtype;
    }

    /**
     * @param sendtype
     */
    public void setSendtype(Integer sendtype) {
        this.sendtype = sendtype;
    }

    /**
     * @return messagetype
     */
    public Integer getMessagetype() {
        return messagetype;
    }

    /**
     * @param messagetype
     */
    public void setMessagetype(Integer messagetype) {
        this.messagetype = messagetype;
    }

    /**
     * @return top
     */
    public Integer getTop() {
        return top;
    }

    /**
     * @param top
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * @return image_url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
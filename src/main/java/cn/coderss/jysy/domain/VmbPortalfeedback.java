package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_portalfeedback")
public class VmbPortalfeedback {
    @Id
    @Column(name = "portalfeedbackId")
    private Integer portalfeedbackid;

    private String mail;

    private String name;

    private String entname;

    private String entsite;

    private String post;

    private String mobile;

    private String ipaddress;

    private Date createtime;

    private String content;

    /**
     * @return portalfeedbackId
     */
    public Integer getPortalfeedbackid() {
        return portalfeedbackid;
    }

    /**
     * @param portalfeedbackid
     */
    public void setPortalfeedbackid(Integer portalfeedbackid) {
        this.portalfeedbackid = portalfeedbackid;
    }

    /**
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
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
     * @return entname
     */
    public String getEntname() {
        return entname;
    }

    /**
     * @param entname
     */
    public void setEntname(String entname) {
        this.entname = entname;
    }

    /**
     * @return entsite
     */
    public String getEntsite() {
        return entsite;
    }

    /**
     * @param entsite
     */
    public void setEntsite(String entsite) {
        this.entsite = entsite;
    }

    /**
     * @return post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return ipaddress
     */
    public String getIpaddress() {
        return ipaddress;
    }

    /**
     * @param ipaddress
     */
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
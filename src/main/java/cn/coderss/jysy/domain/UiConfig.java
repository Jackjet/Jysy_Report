package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "ui_config")
public class UiConfig {
    @Id
    private Integer collegeid;

    @Id
    private Integer enterpriseid;

    @Id
    private String terminal;

    @Column(name = "ui_type")
    private Integer uiType;

    @Column(name = "ui_bg_pic_url")
    private String uiBgPicUrl;

    @Column(name = "ui_logo")
    private String uiLogo;

    @Column(name = "ui_copy_right")
    private String uiCopyRight;

    @Column(name = "templete_url")
    private String templeteUrl;

    private String appid;

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

    /**
     * @return terminal
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * @param terminal
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * @return ui_type
     */
    public Integer getUiType() {
        return uiType;
    }

    /**
     * @param uiType
     */
    public void setUiType(Integer uiType) {
        this.uiType = uiType;
    }

    /**
     * @return ui_bg_pic_url
     */
    public String getUiBgPicUrl() {
        return uiBgPicUrl;
    }

    /**
     * @param uiBgPicUrl
     */
    public void setUiBgPicUrl(String uiBgPicUrl) {
        this.uiBgPicUrl = uiBgPicUrl;
    }

    /**
     * @return ui_logo
     */
    public String getUiLogo() {
        return uiLogo;
    }

    /**
     * @param uiLogo
     */
    public void setUiLogo(String uiLogo) {
        this.uiLogo = uiLogo;
    }

    /**
     * @return ui_copy_right
     */
    public String getUiCopyRight() {
        return uiCopyRight;
    }

    /**
     * @param uiCopyRight
     */
    public void setUiCopyRight(String uiCopyRight) {
        this.uiCopyRight = uiCopyRight;
    }

    /**
     * @return templete_url
     */
    public String getTempleteUrl() {
        return templeteUrl;
    }

    /**
     * @param templeteUrl
     */
    public void setTempleteUrl(String templeteUrl) {
        this.templeteUrl = templeteUrl;
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
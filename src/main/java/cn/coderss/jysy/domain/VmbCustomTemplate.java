package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_custom_template")
public class VmbCustomTemplate {
    @Id
    private Integer customid;

    @Column(name = "go_url")
    private String goUrl;

    private String html;

    @Column(name = "must_login")
    private Integer mustLogin;

    /**
     * @return customid
     */
    public Integer getCustomid() {
        return customid;
    }

    /**
     * @param customid
     */
    public void setCustomid(Integer customid) {
        this.customid = customid;
    }

    /**
     * @return go_url
     */
    public String getGoUrl() {
        return goUrl;
    }

    /**
     * @param goUrl
     */
    public void setGoUrl(String goUrl) {
        this.goUrl = goUrl;
    }

    /**
     * @return html
     */
    public String getHtml() {
        return html;
    }

    /**
     * @param html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * @return must_login
     */
    public Integer getMustLogin() {
        return mustLogin;
    }

    /**
     * @param mustLogin
     */
    public void setMustLogin(Integer mustLogin) {
        this.mustLogin = mustLogin;
    }
}
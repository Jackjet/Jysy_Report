package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_certificate")
public class VmbCertificate {
    /**
     * 证书id
     */
    @Id
    private Integer learningactivityid;

    /**
     * 证书模版url
     */
    private String templateurl;

    /**
     * 发行机构
     */
    private String issuer;

    /**
     * 分数来源
     */
    private Integer scoresourceid;

    /**
     * 获取证书id
     *
     * @return learningactivityid - 证书id
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置证书id
     *
     * @param learningactivityid 证书id
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取证书模版url
     *
     * @return templateurl - 证书模版url
     */
    public String getTemplateurl() {
        return templateurl;
    }

    /**
     * 设置证书模版url
     *
     * @param templateurl 证书模版url
     */
    public void setTemplateurl(String templateurl) {
        this.templateurl = templateurl;
    }

    /**
     * 获取发行机构
     *
     * @return issuer - 发行机构
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * 设置发行机构
     *
     * @param issuer 发行机构
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * 获取分数来源
     *
     * @return scoresourceid - 分数来源
     */
    public Integer getScoresourceid() {
        return scoresourceid;
    }

    /**
     * 设置分数来源
     *
     * @param scoresourceid 分数来源
     */
    public void setScoresourceid(Integer scoresourceid) {
        this.scoresourceid = scoresourceid;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_college")
public class VmbCollege {
    /**
     * 学院Id
     */
    @Id
    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * 学院所属企业
     */
    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 学院风格
     */
    @Column(name = "styleId")
    private Integer styleid;

    /**
     * 学院编号（自动生成，前缀（CL）+六位数字）
     */
    private String code;

    /**
     * 学院名称
     */
    private String name;

    /**
     * 学院Logo
     */
    private String logourl;

    /**
     * 企业BannerUrl
     */
    private String bannerurl;

    /**
     * 学院简介
     */
    private String description;

    /**
     * 学院域名
     */
    private String domain;

    /**
     * 是否开放注册
     */
    private Integer ispublic;

    /**
     * 允许的最大管理员数量
     */
    private Integer admincount;

    @Column(name = "required_login")
    private Integer requiredLogin;

    private Integer states;

    private Date createtime;

    @Column(name = "default_orgid")
    private Integer defaultOrgid;

    private String beian;

    private Integer originalid;

    @Column(name = "banner_color")
    private String bannerColor;

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
     * 获取学院所属企业
     *
     * @return enterpriseId - 学院所属企业
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * 设置学院所属企业
     *
     * @param enterpriseid 学院所属企业
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * 获取学院风格
     *
     * @return styleId - 学院风格
     */
    public Integer getStyleid() {
        return styleid;
    }

    /**
     * 设置学院风格
     *
     * @param styleid 学院风格
     */
    public void setStyleid(Integer styleid) {
        this.styleid = styleid;
    }

    /**
     * 获取学院编号（自动生成，前缀（CL）+六位数字）
     *
     * @return code - 学院编号（自动生成，前缀（CL）+六位数字）
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置学院编号（自动生成，前缀（CL）+六位数字）
     *
     * @param code 学院编号（自动生成，前缀（CL）+六位数字）
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取学院名称
     *
     * @return name - 学院名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学院名称
     *
     * @param name 学院名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学院Logo
     *
     * @return logourl - 学院Logo
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * 设置学院Logo
     *
     * @param logourl 学院Logo
     */
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    /**
     * 获取企业BannerUrl
     *
     * @return bannerurl - 企业BannerUrl
     */
    public String getBannerurl() {
        return bannerurl;
    }

    /**
     * 设置企业BannerUrl
     *
     * @param bannerurl 企业BannerUrl
     */
    public void setBannerurl(String bannerurl) {
        this.bannerurl = bannerurl;
    }

    /**
     * 获取学院简介
     *
     * @return description - 学院简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置学院简介
     *
     * @param description 学院简介
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取学院域名
     *
     * @return domain - 学院域名
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 设置学院域名
     *
     * @param domain 学院域名
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 获取是否开放注册
     *
     * @return ispublic - 是否开放注册
     */
    public Integer getIspublic() {
        return ispublic;
    }

    /**
     * 设置是否开放注册
     *
     * @param ispublic 是否开放注册
     */
    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    /**
     * 获取允许的最大管理员数量
     *
     * @return admincount - 允许的最大管理员数量
     */
    public Integer getAdmincount() {
        return admincount;
    }

    /**
     * 设置允许的最大管理员数量
     *
     * @param admincount 允许的最大管理员数量
     */
    public void setAdmincount(Integer admincount) {
        this.admincount = admincount;
    }

    /**
     * @return required_login
     */
    public Integer getRequiredLogin() {
        return requiredLogin;
    }

    /**
     * @param requiredLogin
     */
    public void setRequiredLogin(Integer requiredLogin) {
        this.requiredLogin = requiredLogin;
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
     * @return default_orgid
     */
    public Integer getDefaultOrgid() {
        return defaultOrgid;
    }

    /**
     * @param defaultOrgid
     */
    public void setDefaultOrgid(Integer defaultOrgid) {
        this.defaultOrgid = defaultOrgid;
    }

    /**
     * @return beian
     */
    public String getBeian() {
        return beian;
    }

    /**
     * @param beian
     */
    public void setBeian(String beian) {
        this.beian = beian;
    }

    /**
     * @return originalid
     */
    public Integer getOriginalid() {
        return originalid;
    }

    /**
     * @param originalid
     */
    public void setOriginalid(Integer originalid) {
        this.originalid = originalid;
    }

    /**
     * @return banner_color
     */
    public String getBannerColor() {
        return bannerColor;
    }

    /**
     * @param bannerColor
     */
    public void setBannerColor(String bannerColor) {
        this.bannerColor = bannerColor;
    }
}
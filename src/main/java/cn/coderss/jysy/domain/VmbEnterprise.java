package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_enterprise")
public class VmbEnterprise {
    @Id
    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 企业简称
     */
    private String shortname;

    /**
     * 英文名称
     */
    private String enname;

    /**
     * 企业门户URL
     */
    private String portalurl;

    /**
     * 企业简介
     */
    private String description;

    /**
     * 行业
     */
    private Integer trade;

    /**
     * 员工人数
     */
    private Integer employeenumber;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 允许用户不使用邮箱作为用户名
     */
    @Column(name = "allowNoEmailLogin")
    private Boolean allownoemaillogin;

    /**
     * 企业用户名后缀
     */
    private String suffix;

    /**
     * 学院数量上限
     */
    private Integer collegecount;

    private Integer admincount;

    private String logourl;

    /**
     * 企业状态
     */
    private Integer states;

    private Date createtime;

    /**
     * 企业所在地区
     */
    private String city;

    /**
     * 企业所在省份
     */
    private String province;

    /**
     * 企业所在县
     */
    private String county;

    private String contact;

    private String phone;

    private String mail;

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
     * 获取企业名称
     *
     * @return name - 企业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业名称
     *
     * @param name 企业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取企业简称
     *
     * @return shortname - 企业简称
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 设置企业简称
     *
     * @param shortname 企业简称
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    /**
     * 获取英文名称
     *
     * @return enname - 英文名称
     */
    public String getEnname() {
        return enname;
    }

    /**
     * 设置英文名称
     *
     * @param enname 英文名称
     */
    public void setEnname(String enname) {
        this.enname = enname;
    }

    /**
     * 获取企业门户URL
     *
     * @return portalurl - 企业门户URL
     */
    public String getPortalurl() {
        return portalurl;
    }

    /**
     * 设置企业门户URL
     *
     * @param portalurl 企业门户URL
     */
    public void setPortalurl(String portalurl) {
        this.portalurl = portalurl;
    }

    /**
     * 获取企业简介
     *
     * @return description - 企业简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置企业简介
     *
     * @param description 企业简介
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取行业
     *
     * @return trade - 行业
     */
    public Integer getTrade() {
        return trade;
    }

    /**
     * 设置行业
     *
     * @param trade 行业
     */
    public void setTrade(Integer trade) {
        this.trade = trade;
    }

    /**
     * 获取员工人数
     *
     * @return employeenumber - 员工人数
     */
    public Integer getEmployeenumber() {
        return employeenumber;
    }

    /**
     * 设置员工人数
     *
     * @param employeenumber 员工人数
     */
    public void setEmployeenumber(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    /**
     * 获取企业地址
     *
     * @return address - 企业地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置企业地址
     *
     * @param address 企业地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取允许用户不使用邮箱作为用户名
     *
     * @return allowNoEmailLogin - 允许用户不使用邮箱作为用户名
     */
    public Boolean getAllownoemaillogin() {
        return allownoemaillogin;
    }

    /**
     * 设置允许用户不使用邮箱作为用户名
     *
     * @param allownoemaillogin 允许用户不使用邮箱作为用户名
     */
    public void setAllownoemaillogin(Boolean allownoemaillogin) {
        this.allownoemaillogin = allownoemaillogin;
    }

    /**
     * 获取企业用户名后缀
     *
     * @return suffix - 企业用户名后缀
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置企业用户名后缀
     *
     * @param suffix 企业用户名后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 获取学院数量上限
     *
     * @return collegecount - 学院数量上限
     */
    public Integer getCollegecount() {
        return collegecount;
    }

    /**
     * 设置学院数量上限
     *
     * @param collegecount 学院数量上限
     */
    public void setCollegecount(Integer collegecount) {
        this.collegecount = collegecount;
    }

    /**
     * @return admincount
     */
    public Integer getAdmincount() {
        return admincount;
    }

    /**
     * @param admincount
     */
    public void setAdmincount(Integer admincount) {
        this.admincount = admincount;
    }

    /**
     * @return logourl
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * @param logourl
     */
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    /**
     * 获取企业状态
     *
     * @return states - 企业状态
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置企业状态
     *
     * @param states 企业状态
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
     * 获取企业所在地区
     *
     * @return city - 企业所在地区
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置企业所在地区
     *
     * @param city 企业所在地区
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取企业所在省份
     *
     * @return province - 企业所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置企业所在省份
     *
     * @param province 企业所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取企业所在县
     *
     * @return county - 企业所在县
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置企业所在县
     *
     * @param county 企业所在县
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
}
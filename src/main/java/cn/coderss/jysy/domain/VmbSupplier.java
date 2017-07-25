package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_supplier")
public class VmbSupplier {
    @Id
    @Column(name = "supplierId")
    private Integer supplierid;

    private String name;

    /**
     * 邮件地址
     */
    private String mail;

    /**
     * 手机号
     */
    private String mobile;

    private String description;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * @return supplierId
     */
    public Integer getSupplierid() {
        return supplierid;
    }

    /**
     * @param supplierid
     */
    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
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
     * 获取邮件地址
     *
     * @return mail - 邮件地址
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮件地址
     *
     * @param mail 邮件地址
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return collegeId
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
}
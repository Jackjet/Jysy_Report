package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_teacher")
public class VmbTeacher {
    @Id
    @Column(name = "teacherId")
    private Integer teacherid;

    /**
     * 讲师姓名
     */
    private String name;

    /**
     * 邮件地址
     */
    private String mail;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 讲师介绍
     */
    private String description;

    /**
     * 讲师所属供应商
     */
    @Column(name = "supplierId")
    private Integer supplierid;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * @return teacherId
     */
    public Integer getTeacherid() {
        return teacherid;
    }

    /**
     * @param teacherid
     */
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    /**
     * 获取讲师姓名
     *
     * @return name - 讲师姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置讲师姓名
     *
     * @param name 讲师姓名
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
     * 获取讲师介绍
     *
     * @return description - 讲师介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置讲师介绍
     *
     * @param description 讲师介绍
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取讲师所属供应商
     *
     * @return supplierId - 讲师所属供应商
     */
    public Integer getSupplierid() {
        return supplierid;
    }

    /**
     * 设置讲师所属供应商
     *
     * @param supplierid 讲师所属供应商
     */
    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
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
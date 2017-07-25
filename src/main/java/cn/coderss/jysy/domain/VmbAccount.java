package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_account")
public class VmbAccount {
    @Id
    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 学员用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 全名（姓名）
     */
    private String fullname;

    /**
     * 邮件地址
     */
    private String mail;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 个人地址
     */
    private String address;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 企业名称
     */
    private String entname;

    /**
     * 企业地址
     */
    private String entaddress;

    /**
     * 企业联系电话
     */
    private String entphone;

    /**
     * 账号所在企业职务
     */
    private String entpost;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 创建用户
     */
    private String createuser;

    private Integer source;

    private Integer sex;

    private Date birthday;

    /**
     * @return accountId
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取学员用户名
     *
     * @return name - 学员用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学员用户名
     *
     * @param name 学员用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取全名（姓名）
     *
     * @return fullname - 全名（姓名）
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 设置全名（姓名）
     *
     * @param fullname 全名（姓名）
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
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
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取个人地址
     *
     * @return address - 个人地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置个人地址
     *
     * @param address 个人地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取微信号
     *
     * @return wechat - 微信号
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信号
     *
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取企业名称
     *
     * @return entname - 企业名称
     */
    public String getEntname() {
        return entname;
    }

    /**
     * 设置企业名称
     *
     * @param entname 企业名称
     */
    public void setEntname(String entname) {
        this.entname = entname;
    }

    /**
     * 获取企业地址
     *
     * @return entaddress - 企业地址
     */
    public String getEntaddress() {
        return entaddress;
    }

    /**
     * 设置企业地址
     *
     * @param entaddress 企业地址
     */
    public void setEntaddress(String entaddress) {
        this.entaddress = entaddress;
    }

    /**
     * 获取企业联系电话
     *
     * @return entphone - 企业联系电话
     */
    public String getEntphone() {
        return entphone;
    }

    /**
     * 设置企业联系电话
     *
     * @param entphone 企业联系电话
     */
    public void setEntphone(String entphone) {
        this.entphone = entphone;
    }

    /**
     * 获取账号所在企业职务
     *
     * @return entpost - 账号所在企业职务
     */
    public String getEntpost() {
        return entpost;
    }

    /**
     * 设置账号所在企业职务
     *
     * @param entpost 账号所在企业职务
     */
    public void setEntpost(String entpost) {
        this.entpost = entpost;
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
     * 获取创建用户
     *
     * @return createuser - 创建用户
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * 设置创建用户
     *
     * @param createuser 创建用户
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    /**
     * @return source
     */
    public Integer getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
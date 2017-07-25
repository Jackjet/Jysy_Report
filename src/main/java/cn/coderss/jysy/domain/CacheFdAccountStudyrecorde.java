package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_fd_account_studyrecorde")
public class CacheFdAccountStudyrecorde {
    @Id
    private Integer id;

    private String province;

    private String city;

    private String country;

    private String unit;

    @Column(name = "unit_type1")
    private String unitType1;

    @Column(name = "unit_type2")
    private String unitType2;

    private String name;

    private String fullname;

    private String sex;

    private String birthday;

    private String email;

    private String position;

    @Column(name = "register_ways")
    private String registerWays;

    @Column(name = "regist_time")
    private String registTime;

    @Column(name = "pay_status")
    private String payStatus;

    @Column(name = "pay_ways")
    private String payWays;

    @Column(name = "pay_time")
    private String payTime;

    private String fapiao;

    private String address;

    private String ok;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return unit_type1
     */
    public String getUnitType1() {
        return unitType1;
    }

    /**
     * @param unitType1
     */
    public void setUnitType1(String unitType1) {
        this.unitType1 = unitType1;
    }

    /**
     * @return unit_type2
     */
    public String getUnitType2() {
        return unitType2;
    }

    /**
     * @param unitType2
     */
    public void setUnitType2(String unitType2) {
        this.unitType2 = unitType2;
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
     * @return fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return register_ways
     */
    public String getRegisterWays() {
        return registerWays;
    }

    /**
     * @param registerWays
     */
    public void setRegisterWays(String registerWays) {
        this.registerWays = registerWays;
    }

    /**
     * @return regist_time
     */
    public String getRegistTime() {
        return registTime;
    }

    /**
     * @param registTime
     */
    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    /**
     * @return pay_status
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * @param payStatus
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * @return pay_ways
     */
    public String getPayWays() {
        return payWays;
    }

    /**
     * @param payWays
     */
    public void setPayWays(String payWays) {
        this.payWays = payWays;
    }

    /**
     * @return pay_time
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * @return fapiao
     */
    public String getFapiao() {
        return fapiao;
    }

    /**
     * @param fapiao
     */
    public void setFapiao(String fapiao) {
        this.fapiao = fapiao;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return ok
     */
    public String getOk() {
        return ok;
    }

    /**
     * @param ok
     */
    public void setOk(String ok) {
        this.ok = ok;
    }
}
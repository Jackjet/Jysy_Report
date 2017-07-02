package cn.coderss.jysy.domain;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午3:01
 * Blog: http://www.coderss.cn
 */
public class JysyModel{
    public String provinceName;
    public String cityName;
    public String countyName;
    public String schoolName;
    public String danwei_1;
    public String danwei_2;
    public String userName;
    public String fullName;
    public String sex;
    public String birthDay;
    public String mail;
    public String zhiWu;
    public String signWays;
    public String createtime;
    public String paySatatus;
    public String payWays;
    public String payTimes;
    public String fapiao;
    public String detailAddress;
    public String finishTime;
    public String cerStatus;
    public String cerTime;
    public String cerCode;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDanwei_1() {
        return danwei_1;
    }

    public void setDanwei_1(String danwei_1) {
        this.danwei_1 = danwei_1;
    }

    public String getDanwei_2() {
        return danwei_2;
    }

    public void setDanwei_2(String danwei_2) {
        this.danwei_2 = danwei_2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getZhiWu() {
        return zhiWu;
    }

    public void setZhiWu(String zhiWu) {
        this.zhiWu = zhiWu;
    }

    public String getSignWays() {
        return signWays;
    }

    public void setSignWays(String signWays) {
        this.signWays = signWays;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPaySatatus() {
        return paySatatus;
    }

    public void setPaySatatus(String paySatatus) {
        this.paySatatus = paySatatus;
    }

    public String getPayWays() {
        return payWays;
    }

    public void setPayWays(String payWays) {
        this.payWays = payWays;
    }

    public String getPayTimes() {
        return payTimes;
    }

    public void setPayTimes(String payTimes) {
        this.payTimes = payTimes;
    }

    public String getFapiao() {
        return fapiao;
    }

    public void setFapiao(String fapiao) {
        this.fapiao = fapiao;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getCerStatus() {
        return cerStatus;
    }

    public void setCerStatus(String cerStatus) {
        this.cerStatus = cerStatus;
    }

    public String getCerTime() {
        return cerTime;
    }

    public void setCerTime(String cerTime) {
        this.cerTime = cerTime;
    }

    public String getCerCode() {
        return cerCode;
    }

    public void setCerCode(String cerCode) {
        this.cerCode = cerCode;
    }

    public JysyModel(String provinceName, String cityName, String countyName, String schoolName, String danwei_1, String danwei_2, String userName, String fullName, String sex, String birthDay, String mail, String zhiWu, String signWays, String createtime, String paySatatus, String payWays, String payTimes, String fapiao, String detailAddress, String finishTime, String cerStatus, String cerTime, String cerCode) {
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.countyName = countyName;
        this.schoolName = schoolName;
        this.danwei_1 = danwei_1;
        this.danwei_2 = danwei_2;
        this.userName = userName;
        this.fullName = fullName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.mail = mail;
        this.zhiWu = zhiWu;
        this.signWays = signWays;
        this.createtime = createtime;
        this.paySatatus = paySatatus;
        this.payWays = payWays;
        this.payTimes = payTimes;
        this.fapiao = fapiao;
        this.detailAddress = detailAddress;
        this.finishTime = finishTime;
        this.cerStatus = cerStatus;
        this.cerTime = cerTime;
        this.cerCode = cerCode;
    }

    @Override
    public String toString() {
        return "JysyModel{" +
                "provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countyName='" + countyName + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", danwei_1='" + danwei_1 + '\'' +
                ", danwei_2='" + danwei_2 + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", mail='" + mail + '\'' +
                ", zhiWu='" + zhiWu + '\'' +
                ", signWays='" + signWays + '\'' +
                ", createtime='" + createtime + '\'' +
                ", paySatatus='" + paySatatus + '\'' +
                ", payWays='" + payWays + '\'' +
                ", payTimes='" + payTimes + '\'' +
                ", fapiao='" + fapiao + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", cerStatus='" + cerStatus + '\'' +
                ", cerTime='" + cerTime + '\'' +
                ", cerCode='" + cerCode + '\'' +
                '}';
    }
}

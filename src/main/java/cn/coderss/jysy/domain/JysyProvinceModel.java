package cn.coderss.jysy.domain;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/24
 * Time: 上午9:50
 * Blog: http://www.coderss.cn
 */

public class JysyProvinceModel {
    public String province;
    public String city;
    public String contry;
    public String sum;
    public String hight;
    public String middle;
    public String base;
    public String sen;
    public String manager;

    public JysyProvinceModel(String province, String city, String contry, String sum, String hight, String middle, String base, String sen, String manager) {
        this.province = province;
        this.city = city;
        this.contry = contry;
        this.sum = sum;
        this.hight = hight;
        this.middle = middle;
        this.base = base;
        this.sen = sen;
        this.manager = manager;
    }

    public String toString() {
        return "JysyProvinceModel{province='" + this.province + '\'' + ", city='" + this.city + '\'' + ", contry='" + this.contry + '\'' + ", sum='" + this.sum + '\'' + ", hight='" + this.hight + '\'' + ", middle='" + this.middle + '\'' + ", base='" + this.base + '\'' + ", sen='" + this.sen + '\'' + ", manager='" + this.manager + '\'' + '}';
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContry() {
        return this.contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getSum() {
        return this.sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getHight() {
        return this.hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public String getMiddle() {
        return this.middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSen() {
        return this.sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }

    public String getManager() {
        return this.manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}


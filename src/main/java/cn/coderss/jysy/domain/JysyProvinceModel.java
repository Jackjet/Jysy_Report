package cn.coderss.jysy.domain;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午2:57
 * Blog: http://www.coderss.cn
 */
public class JysyProvinceModel{
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

    @Override
    public String toString() {
        return "JysyProvinceModel{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", contry='" + contry + '\'' +
                ", sum='" + sum + '\'' +
                ", hight='" + hight + '\'' +
                ", middle='" + middle + '\'' +
                ", base='" + base + '\'' +
                ", sen='" + sen + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}

package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_product")
public class VmbProduct {
    @Id
    private Integer productid;

    /**
     * 产品的单价
     */
    private BigDecimal price;

    /**
     * 产品的名称
     */
    private String name;

    /**
     * 产品的描述
     */
    private String description;

    private Date createtime;

    private Integer collegeid;

    private Integer enterpriseid;

    private Integer accountid;

    /**
     * @return productid
     */
    public Integer getProductid() {
        return productid;
    }

    /**
     * @param productid
     */
    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    /**
     * 获取产品的单价
     *
     * @return price - 产品的单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置产品的单价
     *
     * @param price 产品的单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取产品的名称
     *
     * @return name - 产品的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品的名称
     *
     * @param name 产品的名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取产品的描述
     *
     * @return description - 产品的描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置产品的描述
     *
     * @param description 产品的描述
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return collegeid
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
     * @return enterpriseid
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
     * @return accountid
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
}
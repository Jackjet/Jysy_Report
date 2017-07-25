package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_orderdetail")
public class VmbOrderdetail {
    @Id
    private Integer detailid;

    private Integer orderid;

    private Integer accountid;

    private Integer productid;

    private Integer quantity;

    private Integer discount;

    private BigDecimal price;

    private Date createtime;

    /**
     * @return detailid
     */
    public Integer getDetailid() {
        return detailid;
    }

    /**
     * @param detailid
     */
    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    /**
     * @return orderid
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * @param orderid
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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
     * @return quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return discount
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * @param discount
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
}
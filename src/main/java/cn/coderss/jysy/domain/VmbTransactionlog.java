package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_transactionlog")
public class VmbTransactionlog {
    @Id
    private Integer logid;

    private Integer orderid;

    /**
     * 订单的金额
     */
    private BigDecimal amount;

    /**
     * 日志类型 （提交的支付日志，返回的支付结果日志）
     */
    private Integer logtype;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户ID
     */
    private Integer accountid;

    private Date logtime;

    /**
     * @return logid
     */
    public Integer getLogid() {
        return logid;
    }

    /**
     * @param logid
     */
    public void setLogid(Integer logid) {
        this.logid = logid;
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
     * 获取订单的金额
     *
     * @return amount - 订单的金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置订单的金额
     *
     * @param amount 订单的金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取日志类型 （提交的支付日志，返回的支付结果日志）
     *
     * @return logtype - 日志类型 （提交的支付日志，返回的支付结果日志）
     */
    public Integer getLogtype() {
        return logtype;
    }

    /**
     * 设置日志类型 （提交的支付日志，返回的支付结果日志）
     *
     * @param logtype 日志类型 （提交的支付日志，返回的支付结果日志）
     */
    public void setLogtype(Integer logtype) {
        this.logtype = logtype;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取用户ID
     *
     * @return accountid - 用户ID
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置用户ID
     *
     * @param accountid 用户ID
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * @return logtime
     */
    public Date getLogtime() {
        return logtime;
    }

    /**
     * @param logtime
     */
    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }
}
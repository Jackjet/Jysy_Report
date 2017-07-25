package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_order")
public class VmbOrder {
    @Id
    private Integer orderid;

    /**
     * 订单号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 订单总金额
     */
    private BigDecimal amount;

    /**
     * 订单账户
     */
    private Integer accountid;

    /**
     * 订单状态（下单中，已确认，已支付，已取消）
     */
    @Column(name = "order_states")
    private Integer orderStates;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    private Integer collegeid;

    private Integer enterpriseid;

    private String ending;

    /**
     * 流水号
     */
    @Column(name = "flow_number")
    private String flowNumber;

    /**
     * 线上支付还是线下汇款还是团体导入
     */
    @Column(name = "pay_ways")
    private Integer payWays;

    /**
     * 订单的折扣
     */
    private Integer discount;

    /**
     * 取消时间
     */
    @Column(name = "cancel_time")
    private Date cancelTime;

    /**
     * 签名信息
     */
    private String sign;

    /**
     * 操作方式
     */
    @Column(name = "operation_mode")
    private String operationMode;

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
     * 获取订单号
     *
     * @return order_number - 订单号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单号
     *
     * @param orderNumber 订单号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取订单总金额
     *
     * @return amount - 订单总金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置订单总金额
     *
     * @param amount 订单总金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取订单账户
     *
     * @return accountid - 订单账户
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置订单账户
     *
     * @param accountid 订单账户
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取订单状态（下单中，已确认，已支付，已取消）
     *
     * @return order_states - 订单状态（下单中，已确认，已支付，已取消）
     */
    public Integer getOrderStates() {
        return orderStates;
    }

    /**
     * 设置订单状态（下单中，已确认，已支付，已取消）
     *
     * @param orderStates 订单状态（下单中，已确认，已支付，已取消）
     */
    public void setOrderStates(Integer orderStates) {
        this.orderStates = orderStates;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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
     * @return ending
     */
    public String getEnding() {
        return ending;
    }

    /**
     * @param ending
     */
    public void setEnding(String ending) {
        this.ending = ending;
    }

    /**
     * 获取流水号
     *
     * @return flow_number - 流水号
     */
    public String getFlowNumber() {
        return flowNumber;
    }

    /**
     * 设置流水号
     *
     * @param flowNumber 流水号
     */
    public void setFlowNumber(String flowNumber) {
        this.flowNumber = flowNumber;
    }

    /**
     * 获取线上支付还是线下汇款还是团体导入
     *
     * @return pay_ways - 线上支付还是线下汇款还是团体导入
     */
    public Integer getPayWays() {
        return payWays;
    }

    /**
     * 设置线上支付还是线下汇款还是团体导入
     *
     * @param payWays 线上支付还是线下汇款还是团体导入
     */
    public void setPayWays(Integer payWays) {
        this.payWays = payWays;
    }

    /**
     * 获取订单的折扣
     *
     * @return discount - 订单的折扣
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * 设置订单的折扣
     *
     * @param discount 订单的折扣
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * 获取取消时间
     *
     * @return cancel_time - 取消时间
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * 设置取消时间
     *
     * @param cancelTime 取消时间
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 获取签名信息
     *
     * @return sign - 签名信息
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置签名信息
     *
     * @param sign 签名信息
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取操作方式
     *
     * @return operation_mode - 操作方式
     */
    public String getOperationMode() {
        return operationMode;
    }

    /**
     * 设置操作方式
     *
     * @param operationMode 操作方式
     */
    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }
}
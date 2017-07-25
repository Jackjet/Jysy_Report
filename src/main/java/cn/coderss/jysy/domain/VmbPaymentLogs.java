package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_payment_logs")
public class VmbPaymentLogs {
    @Id
    private Integer logid;

    private Integer accountid;

    @Column(name = "op_accountid")
    private Integer opAccountid;

    @Column(name = "old_pay_ways")
    private Integer oldPayWays;

    @Column(name = "new_pay_ways")
    private Integer newPayWays;

    private Date createtime;

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
     * @return op_accountid
     */
    public Integer getOpAccountid() {
        return opAccountid;
    }

    /**
     * @param opAccountid
     */
    public void setOpAccountid(Integer opAccountid) {
        this.opAccountid = opAccountid;
    }

    /**
     * @return old_pay_ways
     */
    public Integer getOldPayWays() {
        return oldPayWays;
    }

    /**
     * @param oldPayWays
     */
    public void setOldPayWays(Integer oldPayWays) {
        this.oldPayWays = oldPayWays;
    }

    /**
     * @return new_pay_ways
     */
    public Integer getNewPayWays() {
        return newPayWays;
    }

    /**
     * @param newPayWays
     */
    public void setNewPayWays(Integer newPayWays) {
        this.newPayWays = newPayWays;
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
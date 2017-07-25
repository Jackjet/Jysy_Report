package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_offline_integral")
public class VmbOfflineIntegral {
    @Id
    private Integer offlineid;

    private Integer accountid;

    /**
     * 积分
     */
    private Integer integral;

    private Date createtime;

    /**
     * @return offlineid
     */
    public Integer getOfflineid() {
        return offlineid;
    }

    /**
     * @param offlineid
     */
    public void setOfflineid(Integer offlineid) {
        this.offlineid = offlineid;
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
     * 获取积分
     *
     * @return integral - 积分
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 设置积分
     *
     * @param integral 积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
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
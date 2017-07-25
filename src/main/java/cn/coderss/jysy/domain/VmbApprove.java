package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_approve")
public class VmbApprove {
    @Id
    private Integer checkid;

    private Integer accountid;

    private Integer collegeid;

    private Integer enterpriseid;

    private Date createtime;

    private Integer destaccountid;

    /**
     * @return checkid
     */
    public Integer getCheckid() {
        return checkid;
    }

    /**
     * @param checkid
     */
    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
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
     * @return destaccountid
     */
    public Integer getDestaccountid() {
        return destaccountid;
    }

    /**
     * @param destaccountid
     */
    public void setDestaccountid(Integer destaccountid) {
        this.destaccountid = destaccountid;
    }
}
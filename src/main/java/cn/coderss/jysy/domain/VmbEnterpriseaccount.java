package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_enterpriseaccount")
public class VmbEnterpriseaccount {
    @Id
    private Integer enterpriseaccountid;

    private Integer enterpriseid;

    private Integer accountid;

    /**
     * 状态
     */
    private Integer states;

    private Date createtime;

    /**
     * 职务
     */
    private String position;

    /**
     * 用户角色
     */
    private String userrole;

    /**
     * @return enterpriseaccountid
     */
    public Integer getEnterpriseaccountid() {
        return enterpriseaccountid;
    }

    /**
     * @param enterpriseaccountid
     */
    public void setEnterpriseaccountid(Integer enterpriseaccountid) {
        this.enterpriseaccountid = enterpriseaccountid;
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

    /**
     * 获取状态
     *
     * @return states - 状态
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置状态
     *
     * @param states 状态
     */
    public void setStates(Integer states) {
        this.states = states;
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
     * 获取职务
     *
     * @return position - 职务
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职务
     *
     * @param position 职务
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取用户角色
     *
     * @return userrole - 用户角色
     */
    public String getUserrole() {
        return userrole;
    }

    /**
     * 设置用户角色
     *
     * @param userrole 用户角色
     */
    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
}
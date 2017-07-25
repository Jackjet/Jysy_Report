package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_shoppingcart")
public class VmbShoppingcart {
    @Id
    @Column(name = "shoppingId")
    private Integer shoppingid;

    /**
     * 发生购买的账户
     */
    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 当前购买对应的活动
     */
    @Column(name = "activityId")
    private Integer activityid;

    @Column(name = "ownershipId")
    private Integer ownershipid;

    /**
     * @return shoppingId
     */
    public Integer getShoppingid() {
        return shoppingid;
    }

    /**
     * @param shoppingid
     */
    public void setShoppingid(Integer shoppingid) {
        this.shoppingid = shoppingid;
    }

    /**
     * 获取发生购买的账户
     *
     * @return accountId - 发生购买的账户
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置发生购买的账户
     *
     * @param accountid 发生购买的账户
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取当前购买对应的活动
     *
     * @return activityId - 当前购买对应的活动
     */
    public Integer getActivityid() {
        return activityid;
    }

    /**
     * 设置当前购买对应的活动
     *
     * @param activityid 当前购买对应的活动
     */
    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    /**
     * @return ownershipId
     */
    public Integer getOwnershipid() {
        return ownershipid;
    }

    /**
     * @param ownershipid
     */
    public void setOwnershipid(Integer ownershipid) {
        this.ownershipid = ownershipid;
    }
}
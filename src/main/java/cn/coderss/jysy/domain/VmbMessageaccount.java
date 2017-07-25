package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_messageaccount")
public class VmbMessageaccount {
    @Id
    @Column(name = "messageaccountId")
    private Integer messageaccountid;

    /**
     * 消息Id
     */
    @Column(name = "messageId")
    private Integer messageid;

    /**
     * 账号Id
     */
    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 是否已读
     */
    private Boolean readed;

    /**
     * 阅读时间
     */
    private Date readtime;

    /**
     * @return messageaccountId
     */
    public Integer getMessageaccountid() {
        return messageaccountid;
    }

    /**
     * @param messageaccountid
     */
    public void setMessageaccountid(Integer messageaccountid) {
        this.messageaccountid = messageaccountid;
    }

    /**
     * 获取消息Id
     *
     * @return messageId - 消息Id
     */
    public Integer getMessageid() {
        return messageid;
    }

    /**
     * 设置消息Id
     *
     * @param messageid 消息Id
     */
    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    /**
     * 获取账号Id
     *
     * @return accountId - 账号Id
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置账号Id
     *
     * @param accountid 账号Id
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取是否已读
     *
     * @return readed - 是否已读
     */
    public Boolean getReaded() {
        return readed;
    }

    /**
     * 设置是否已读
     *
     * @param readed 是否已读
     */
    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    /**
     * 获取阅读时间
     *
     * @return readtime - 阅读时间
     */
    public Date getReadtime() {
        return readtime;
    }

    /**
     * 设置阅读时间
     *
     * @param readtime 阅读时间
     */
    public void setReadtime(Date readtime) {
        this.readtime = readtime;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sso_group_register_sendmsg")
public class SsoGroupRegisterSendmsg {
    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 是否已发送短信的标记 默认为0表示未发送    1 表示已发送过
     */
    @Column(name = "sent_flg")
    private Integer sentFlg;

    /**
     * 姓名
     */
    private String fullname;

    private String orgname;

    /**
     * 消息内容类型
     */
    @Column(name = "info_flag")
    private Integer infoFlag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取是否已发送短信的标记 默认为0表示未发送    1 表示已发送过
     *
     * @return sent_flg - 是否已发送短信的标记 默认为0表示未发送    1 表示已发送过
     */
    public Integer getSentFlg() {
        return sentFlg;
    }

    /**
     * 设置是否已发送短信的标记 默认为0表示未发送    1 表示已发送过
     *
     * @param sentFlg 是否已发送短信的标记 默认为0表示未发送    1 表示已发送过
     */
    public void setSentFlg(Integer sentFlg) {
        this.sentFlg = sentFlg;
    }

    /**
     * 获取姓名
     *
     * @return fullname - 姓名
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 设置姓名
     *
     * @param fullname 姓名
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return orgname
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * @param orgname
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    /**
     * 获取消息内容类型
     *
     * @return info_flag - 消息内容类型
     */
    public Integer getInfoFlag() {
        return infoFlag;
    }

    /**
     * 设置消息内容类型
     *
     * @param infoFlag 消息内容类型
     */
    public void setInfoFlag(Integer infoFlag) {
        this.infoFlag = infoFlag;
    }
}
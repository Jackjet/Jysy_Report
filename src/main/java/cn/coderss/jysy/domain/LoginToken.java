package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "login_token")
public class LoginToken {
    @Id
    @Column(name = "login_token")
    private String loginToken;

    private Integer accountid;

    private Date createtime;

    @Column(name = "login_appid")
    private String loginAppid;

    /**
     * @return login_token
     */
    public String getLoginToken() {
        return loginToken;
    }

    /**
     * @param loginToken
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
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
     * @return login_appid
     */
    public String getLoginAppid() {
        return loginAppid;
    }

    /**
     * @param loginAppid
     */
    public void setLoginAppid(String loginAppid) {
        this.loginAppid = loginAppid;
    }
}
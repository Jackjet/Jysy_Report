package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sf_token_log")
public class SfTokenLog {
    @Id
    @Column(name = "token_log_id")
    private Integer tokenLogId;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "error_msg")
    private String errorMsg;

    private Date createtime;

    @Column(name = "token_id")
    private Integer tokenId;

    private String ip;

    private String token;

    private String gets;

    private String posts;

    /**
     * @return token_log_id
     */
    public Integer getTokenLogId() {
        return tokenLogId;
    }

    /**
     * @param tokenLogId
     */
    public void setTokenLogId(Integer tokenLogId) {
        this.tokenLogId = tokenLogId;
    }

    /**
     * @return error_code
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return error_msg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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
     * @return token_id
     */
    public Integer getTokenId() {
        return tokenId;
    }

    /**
     * @param tokenId
     */
    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return gets
     */
    public String getGets() {
        return gets;
    }

    /**
     * @param gets
     */
    public void setGets(String gets) {
        this.gets = gets;
    }

    /**
     * @return posts
     */
    public String getPosts() {
        return posts;
    }

    /**
     * @param posts
     */
    public void setPosts(String posts) {
        this.posts = posts;
    }
}
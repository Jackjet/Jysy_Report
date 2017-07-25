package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sf_token")
public class SfToken {
    @Id
    @Column(name = "token_id")
    private Integer tokenId;

    private String token;

    @Column(name = "servicepermission_id")
    private Integer servicepermissionId;

    @Column(name = "expire_time")
    private Date expireTime;

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
     * @return servicepermission_id
     */
    public Integer getServicepermissionId() {
        return servicepermissionId;
    }

    /**
     * @param servicepermissionId
     */
    public void setServicepermissionId(Integer servicepermissionId) {
        this.servicepermissionId = servicepermissionId;
    }

    /**
     * @return expire_time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
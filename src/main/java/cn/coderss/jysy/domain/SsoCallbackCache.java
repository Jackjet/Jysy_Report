package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sso_callback_cache")
public class SsoCallbackCache {
    @Id
    @Column(name = "cache_key")
    private String cacheKey;

    @Column(name = "cache_value")
    private String cacheValue;

    private Date createtime;

    /**
     * @return cache_key
     */
    public String getCacheKey() {
        return cacheKey;
    }

    /**
     * @param cacheKey
     */
    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    /**
     * @return cache_value
     */
    public String getCacheValue() {
        return cacheValue;
    }

    /**
     * @param cacheValue
     */
    public void setCacheValue(String cacheValue) {
        this.cacheValue = cacheValue;
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
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "django_session")
public class DjangoSession {
    @Id
    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "session_data")
    private String sessionData;

    /**
     * @return session_key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * @return expire_date
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * @return session_data
     */
    public String getSessionData() {
        return sessionData;
    }

    /**
     * @param sessionData
     */
    public void setSessionData(String sessionData) {
        this.sessionData = sessionData;
    }
}
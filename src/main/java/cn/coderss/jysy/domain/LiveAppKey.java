package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "live_app_key")
public class LiveAppKey {
    @Id
    private Integer keyid;

    private Integer channelid;

    private String secretkey;

    /**
     * @return keyid
     */
    public Integer getKeyid() {
        return keyid;
    }

    /**
     * @param keyid
     */
    public void setKeyid(Integer keyid) {
        this.keyid = keyid;
    }

    /**
     * @return channelid
     */
    public Integer getChannelid() {
        return channelid;
    }

    /**
     * @param channelid
     */
    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
    }

    /**
     * @return secretkey
     */
    public String getSecretkey() {
        return secretkey;
    }

    /**
     * @param secretkey
     */
    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }
}
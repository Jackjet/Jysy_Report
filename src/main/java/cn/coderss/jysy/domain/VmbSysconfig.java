package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_sysconfig")
public class VmbSysconfig {
    @Id
    @Column(name = "configId")
    private Integer configid;

    private Boolean wxdebug;

    /**
     * @return configId
     */
    public Integer getConfigid() {
        return configid;
    }

    /**
     * @param configid
     */
    public void setConfigid(Integer configid) {
        this.configid = configid;
    }

    /**
     * @return wxdebug
     */
    public Boolean getWxdebug() {
        return wxdebug;
    }

    /**
     * @param wxdebug
     */
    public void setWxdebug(Boolean wxdebug) {
        this.wxdebug = wxdebug;
    }
}
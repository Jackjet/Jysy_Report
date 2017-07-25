package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_apiblacklist")
public class VmbApiblacklist {
    @Id
    @Column(name = "blackId")
    private Integer blackid;

    @Column(name = "IPAddress")
    private String ipaddress;

    /**
     * @return blackId
     */
    public Integer getBlackid() {
        return blackid;
    }

    /**
     * @param blackid
     */
    public void setBlackid(Integer blackid) {
        this.blackid = blackid;
    }

    /**
     * @return IPAddress
     */
    public String getIpaddress() {
        return ipaddress;
    }

    /**
     * @param ipaddress
     */
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }
}
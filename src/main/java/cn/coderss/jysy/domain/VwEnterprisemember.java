package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_enterprisemember")
public class VwEnterprisemember {
    private Byte accountid;

    private Byte enterpriseid;

    private Byte entname;

    /**
     * @return accountid
     */
    public Byte getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Byte accountid) {
        this.accountid = accountid;
    }

    /**
     * @return enterpriseid
     */
    public Byte getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Byte enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * @return entname
     */
    public Byte getEntname() {
        return entname;
    }

    /**
     * @param entname
     */
    public void setEntname(Byte entname) {
        this.entname = entname;
    }
}
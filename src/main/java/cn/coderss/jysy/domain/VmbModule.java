package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_module")
public class VmbModule {
    @Id
    private Integer moduleid;

    private String modulecode;

    private String modulename;

    private Integer areaid;

    private Integer pageid;

    /**
     * @return moduleid
     */
    public Integer getModuleid() {
        return moduleid;
    }

    /**
     * @param moduleid
     */
    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    /**
     * @return modulecode
     */
    public String getModulecode() {
        return modulecode;
    }

    /**
     * @param modulecode
     */
    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    /**
     * @return modulename
     */
    public String getModulename() {
        return modulename;
    }

    /**
     * @param modulename
     */
    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    /**
     * @return areaid
     */
    public Integer getAreaid() {
        return areaid;
    }

    /**
     * @param areaid
     */
    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    /**
     * @return pageid
     */
    public Integer getPageid() {
        return pageid;
    }

    /**
     * @param pageid
     */
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }
}
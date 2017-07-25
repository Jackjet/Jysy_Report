package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_area")
public class VmbArea {
    @Id
    private Integer areaid;

    private String areacode;

    private String areaname;

    private Integer pageid;

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
     * @return areacode
     */
    public String getAreacode() {
        return areacode;
    }

    /**
     * @param areacode
     */
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    /**
     * @return areaname
     */
    public String getAreaname() {
        return areaname;
    }

    /**
     * @param areaname
     */
    public void setAreaname(String areaname) {
        this.areaname = areaname;
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
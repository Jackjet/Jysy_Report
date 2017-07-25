package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_serialnumber")
public class VmbSerialnumber {
    @Id
    private String serialtype;

    @Id
    private String date;

    @Id
    private Integer indexvalue;

    /**
     * @return serialtype
     */
    public String getSerialtype() {
        return serialtype;
    }

    /**
     * @param serialtype
     */
    public void setSerialtype(String serialtype) {
        this.serialtype = serialtype;
    }

    /**
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return indexvalue
     */
    public Integer getIndexvalue() {
        return indexvalue;
    }

    /**
     * @param indexvalue
     */
    public void setIndexvalue(Integer indexvalue) {
        this.indexvalue = indexvalue;
    }
}
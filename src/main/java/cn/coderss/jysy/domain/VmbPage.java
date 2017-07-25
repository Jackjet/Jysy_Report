package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_page")
public class VmbPage {
    @Id
    private Integer pageid;

    private String pagecode;

    private String pagename;

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

    /**
     * @return pagecode
     */
    public String getPagecode() {
        return pagecode;
    }

    /**
     * @param pagecode
     */
    public void setPagecode(String pagecode) {
        this.pagecode = pagecode;
    }

    /**
     * @return pagename
     */
    public String getPagename() {
        return pagename;
    }

    /**
     * @param pagename
     */
    public void setPagename(String pagename) {
        this.pagename = pagename;
    }
}
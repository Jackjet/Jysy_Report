package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_anonymous_permission")
public class VmbAnonymousPermission {
    @Id
    @Column(name = "anonymousId")
    private Integer anonymousid;

    @Column(name = "page_name")
    private String pageName;

    private Integer collegeid;

    private Date createtime;

    private Integer createuserid;

    /**
     * @return anonymousId
     */
    public Integer getAnonymousid() {
        return anonymousid;
    }

    /**
     * @param anonymousid
     */
    public void setAnonymousid(Integer anonymousid) {
        this.anonymousid = anonymousid;
    }

    /**
     * @return page_name
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * @param pageName
     */
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * @return collegeid
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * @param collegeid
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
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

    /**
     * @return createuserid
     */
    public Integer getCreateuserid() {
        return createuserid;
    }

    /**
     * @param createuserid
     */
    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }
}
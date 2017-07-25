package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_managelog")
public class VmbManagelog {
    @Id
    private Integer logid;

    private Integer accountid;

    private String url;

    private String get;

    private Date createtime;

    private String post;

    private String header;

    private Integer logtype;

    private String exceptionstack;

    /**
     * @return logid
     */
    public Integer getLogid() {
        return logid;
    }

    /**
     * @param logid
     */
    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    /**
     * @return accountid
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return get
     */
    public String getGet() {
        return get;
    }

    /**
     * @param get
     */
    public void setGet(String get) {
        this.get = get;
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
     * @return post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return logtype
     */
    public Integer getLogtype() {
        return logtype;
    }

    /**
     * @param logtype
     */
    public void setLogtype(Integer logtype) {
        this.logtype = logtype;
    }

    /**
     * @return exceptionstack
     */
    public String getExceptionstack() {
        return exceptionstack;
    }

    /**
     * @param exceptionstack
     */
    public void setExceptionstack(String exceptionstack) {
        this.exceptionstack = exceptionstack;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_api_log")
public class VmbApiLog {
    @Id
    private Integer logid;

    private String funccode;

    private String funcname;

    private String funcurl;

    private Date createtime;

    private String request;

    private String result;

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
     * @return funccode
     */
    public String getFunccode() {
        return funccode;
    }

    /**
     * @param funccode
     */
    public void setFunccode(String funccode) {
        this.funccode = funccode;
    }

    /**
     * @return funcname
     */
    public String getFuncname() {
        return funcname;
    }

    /**
     * @param funcname
     */
    public void setFuncname(String funcname) {
        this.funcname = funcname;
    }

    /**
     * @return funcurl
     */
    public String getFuncurl() {
        return funcurl;
    }

    /**
     * @param funcurl
     */
    public void setFuncurl(String funcurl) {
        this.funcurl = funcurl;
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
     * @return request
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }
}
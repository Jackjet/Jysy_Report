package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "login_log")
public class LoginLog {
    @Id
    private Integer logid;

    private String name;

    private String ip;

    private Integer successfull;

    private String resaon;

    private Date createtime;

    private String appid;

    private Integer collegeid;

    @Column(name = "request_appid")
    private String requestAppid;

    private Integer enterpriseid;

    private String terminal;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return successfull
     */
    public Integer getSuccessfull() {
        return successfull;
    }

    /**
     * @param successfull
     */
    public void setSuccessfull(Integer successfull) {
        this.successfull = successfull;
    }

    /**
     * @return resaon
     */
    public String getResaon() {
        return resaon;
    }

    /**
     * @param resaon
     */
    public void setResaon(String resaon) {
        this.resaon = resaon;
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
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
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
     * @return request_appid
     */
    public String getRequestAppid() {
        return requestAppid;
    }

    /**
     * @param requestAppid
     */
    public void setRequestAppid(String requestAppid) {
        this.requestAppid = requestAppid;
    }

    /**
     * @return enterpriseid
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * @return terminal
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * @param terminal
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sf_serviceinfo")
public class SfServiceinfo {
    @Id
    @Column(name = "serviceinfo_id")
    private Integer serviceinfoId;

    /**
     * ????
     */
    @Column(name = "service_code")
    private String serviceCode;

    /**
     * ????
     */
    private String name;

    /**
     * ????
     */
    private String description;

    /**
     * ???Id
     */
    private Integer createaccountid;

    /**
     * ????
     */
    private Date createtime;

    @Column(name = "invoke_url")
    private String invokeUrl;

    /**
     * @return serviceinfo_id
     */
    public Integer getServiceinfoId() {
        return serviceinfoId;
    }

    /**
     * @param serviceinfoId
     */
    public void setServiceinfoId(Integer serviceinfoId) {
        this.serviceinfoId = serviceinfoId;
    }

    /**
     * 获取????
     *
     * @return service_code - ????
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * 设置????
     *
     * @param serviceCode ????
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 获取????
     *
     * @return name - ????
     */
    public String getName() {
        return name;
    }

    /**
     * 设置????
     *
     * @param name ????
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取????
     *
     * @return description - ????
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置????
     *
     * @param description ????
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取???Id
     *
     * @return createaccountid - ???Id
     */
    public Integer getCreateaccountid() {
        return createaccountid;
    }

    /**
     * 设置???Id
     *
     * @param createaccountid ???Id
     */
    public void setCreateaccountid(Integer createaccountid) {
        this.createaccountid = createaccountid;
    }

    /**
     * 获取????
     *
     * @return createtime - ????
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置????
     *
     * @param createtime ????
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return invoke_url
     */
    public String getInvokeUrl() {
        return invokeUrl;
    }

    /**
     * @param invokeUrl
     */
    public void setInvokeUrl(String invokeUrl) {
        this.invokeUrl = invokeUrl;
    }
}
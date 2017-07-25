package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sf_servicepermission")
public class SfServicepermission {
    @Id
    @Column(name = "servicepermission_id")
    private Integer servicepermissionId;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "app_secret")
    private String appSecret;

    @Column(name = "dest_service_id")
    private Integer destServiceId;

    @Column(name = "source_service_id")
    private Integer sourceServiceId;

    private Integer collegeid;

    private Integer enterpriseid;

    private Date createtime;

    /**
     * @return servicepermission_id
     */
    public Integer getServicepermissionId() {
        return servicepermissionId;
    }

    /**
     * @param servicepermissionId
     */
    public void setServicepermissionId(Integer servicepermissionId) {
        this.servicepermissionId = servicepermissionId;
    }

    /**
     * @return app_id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return app_secret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * @param appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * @return dest_service_id
     */
    public Integer getDestServiceId() {
        return destServiceId;
    }

    /**
     * @param destServiceId
     */
    public void setDestServiceId(Integer destServiceId) {
        this.destServiceId = destServiceId;
    }

    /**
     * @return source_service_id
     */
    public Integer getSourceServiceId() {
        return sourceServiceId;
    }

    /**
     * @param sourceServiceId
     */
    public void setSourceServiceId(Integer sourceServiceId) {
        this.sourceServiceId = sourceServiceId;
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
}
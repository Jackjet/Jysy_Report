package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "sf_api_info")
public class SfApiInfo {
    @Id
    @Column(name = "api_infoid")
    private Integer apiInfoid;

    private String code;

    private String name;

    private String description;

    private String params;

    @Column(name = "service_id")
    private Integer serviceId;

    private String path;

    /**
     * @return api_infoid
     */
    public Integer getApiInfoid() {
        return apiInfoid;
    }

    /**
     * @param apiInfoid
     */
    public void setApiInfoid(Integer apiInfoid) {
        this.apiInfoid = apiInfoid;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return params
     */
    public String getParams() {
        return params;
    }

    /**
     * @param params
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * @return service_id
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }
}
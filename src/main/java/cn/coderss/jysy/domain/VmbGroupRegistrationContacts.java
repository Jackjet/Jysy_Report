package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_group_registration_contacts")
public class VmbGroupRegistrationContacts {
    @Id
    private Integer contactid;

    private String orgname;

    private String contactname;

    private String mobile;

    private String mail;

    private Integer provinceid;

    @Column(name = "excel_url")
    private String excelUrl;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "excel_result_url")
    private String excelResultUrl;

    private Integer states;

    private Date committime;

    private Integer complete;

    @Column(name = "create_result")
    private String createResult;

    @Column(name = "create_result_url")
    private String createResultUrl;

    private Integer cityid;

    private Integer countyid;

    private Integer status;

    /**
     * @return contactid
     */
    public Integer getContactid() {
        return contactid;
    }

    /**
     * @param contactid
     */
    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    /**
     * @return orgname
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * @param orgname
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    /**
     * @return contactname
     */
    public String getContactname() {
        return contactname;
    }

    /**
     * @param contactname
     */
    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return provinceid
     */
    public Integer getProvinceid() {
        return provinceid;
    }

    /**
     * @param provinceid
     */
    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    /**
     * @return excel_url
     */
    public String getExcelUrl() {
        return excelUrl;
    }

    /**
     * @param excelUrl
     */
    public void setExcelUrl(String excelUrl) {
        this.excelUrl = excelUrl;
    }

    /**
     * @return batch_number
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * @param batchNumber
     */
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    /**
     * @return excel_result_url
     */
    public String getExcelResultUrl() {
        return excelResultUrl;
    }

    /**
     * @param excelResultUrl
     */
    public void setExcelResultUrl(String excelResultUrl) {
        this.excelResultUrl = excelResultUrl;
    }

    /**
     * @return states
     */
    public Integer getStates() {
        return states;
    }

    /**
     * @param states
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * @return committime
     */
    public Date getCommittime() {
        return committime;
    }

    /**
     * @param committime
     */
    public void setCommittime(Date committime) {
        this.committime = committime;
    }

    /**
     * @return complete
     */
    public Integer getComplete() {
        return complete;
    }

    /**
     * @param complete
     */
    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    /**
     * @return create_result
     */
    public String getCreateResult() {
        return createResult;
    }

    /**
     * @param createResult
     */
    public void setCreateResult(String createResult) {
        this.createResult = createResult;
    }

    /**
     * @return create_result_url
     */
    public String getCreateResultUrl() {
        return createResultUrl;
    }

    /**
     * @param createResultUrl
     */
    public void setCreateResultUrl(String createResultUrl) {
        this.createResultUrl = createResultUrl;
    }

    /**
     * @return cityid
     */
    public Integer getCityid() {
        return cityid;
    }

    /**
     * @param cityid
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    /**
     * @return countyid
     */
    public Integer getCountyid() {
        return countyid;
    }

    /**
     * @param countyid
     */
    public void setCountyid(Integer countyid) {
        this.countyid = countyid;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
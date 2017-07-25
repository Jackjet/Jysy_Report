package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "celery_taskinfo")
public class CeleryTaskinfo {
    @Id
    private Integer taskid;

    private String code;

    private Integer type;

    private Integer states;

    private Date createtime;

    private Date starttime;

    private Date endtime;

    @Column(name = "result_file")
    private String resultFile;

    private Integer collegeid;

    private Integer enterpriseid;

    private Integer accountid;

    @Column(name = "import_file")
    private String importFile;

    @Column(name = "result_states")
    private Integer resultStates;

    private String domain;

    @Column(name = "import_description")
    private String importDescription;

    @Column(name = "import_params")
    private String importParams;

    @Column(name = "result_description")
    private String resultDescription;

    @Column(name = "result_error_stack")
    private String resultErrorStack;

    /**
     * @return taskid
     */
    public Integer getTaskid() {
        return taskid;
    }

    /**
     * @param taskid
     */
    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
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
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * @param starttime
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * @return endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * @return result_file
     */
    public String getResultFile() {
        return resultFile;
    }

    /**
     * @param resultFile
     */
    public void setResultFile(String resultFile) {
        this.resultFile = resultFile;
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
     * @return import_file
     */
    public String getImportFile() {
        return importFile;
    }

    /**
     * @param importFile
     */
    public void setImportFile(String importFile) {
        this.importFile = importFile;
    }

    /**
     * @return result_states
     */
    public Integer getResultStates() {
        return resultStates;
    }

    /**
     * @param resultStates
     */
    public void setResultStates(Integer resultStates) {
        this.resultStates = resultStates;
    }

    /**
     * @return domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return import_description
     */
    public String getImportDescription() {
        return importDescription;
    }

    /**
     * @param importDescription
     */
    public void setImportDescription(String importDescription) {
        this.importDescription = importDescription;
    }

    /**
     * @return import_params
     */
    public String getImportParams() {
        return importParams;
    }

    /**
     * @param importParams
     */
    public void setImportParams(String importParams) {
        this.importParams = importParams;
    }

    /**
     * @return result_description
     */
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     * @param resultDescription
     */
    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    /**
     * @return result_error_stack
     */
    public String getResultErrorStack() {
        return resultErrorStack;
    }

    /**
     * @param resultErrorStack
     */
    public void setResultErrorStack(String resultErrorStack) {
        this.resultErrorStack = resultErrorStack;
    }
}
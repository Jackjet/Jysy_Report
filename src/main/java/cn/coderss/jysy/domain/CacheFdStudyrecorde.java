package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_fd_studyrecorde")
public class CacheFdStudyrecorde {
    @Id
    private Integer id;

    @Column(name = "lear_id")
    private Integer learId;

    @Column(name = "lear_code")
    private String learCode;

    @Column(name = "lear_name")
    private String learName;

    @Column(name = "issue_name")
    private String issueName;

    @Column(name = "issue_code")
    private String issueCode;

    @Column(name = "rel_activityid")
    private Integer relActivityid;

    @Column(name = "rel_code")
    private String relCode;

    @Column(name = "rel_name")
    private String relName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return lear_id
     */
    public Integer getLearId() {
        return learId;
    }

    /**
     * @param learId
     */
    public void setLearId(Integer learId) {
        this.learId = learId;
    }

    /**
     * @return lear_code
     */
    public String getLearCode() {
        return learCode;
    }

    /**
     * @param learCode
     */
    public void setLearCode(String learCode) {
        this.learCode = learCode;
    }

    /**
     * @return lear_name
     */
    public String getLearName() {
        return learName;
    }

    /**
     * @param learName
     */
    public void setLearName(String learName) {
        this.learName = learName;
    }

    /**
     * @return issue_name
     */
    public String getIssueName() {
        return issueName;
    }

    /**
     * @param issueName
     */
    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    /**
     * @return issue_code
     */
    public String getIssueCode() {
        return issueCode;
    }

    /**
     * @param issueCode
     */
    public void setIssueCode(String issueCode) {
        this.issueCode = issueCode;
    }

    /**
     * @return rel_activityid
     */
    public Integer getRelActivityid() {
        return relActivityid;
    }

    /**
     * @param relActivityid
     */
    public void setRelActivityid(Integer relActivityid) {
        this.relActivityid = relActivityid;
    }

    /**
     * @return rel_code
     */
    public String getRelCode() {
        return relCode;
    }

    /**
     * @param relCode
     */
    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    /**
     * @return rel_name
     */
    public String getRelName() {
        return relName;
    }

    /**
     * @param relName
     */
    public void setRelName(String relName) {
        this.relName = relName;
    }
}
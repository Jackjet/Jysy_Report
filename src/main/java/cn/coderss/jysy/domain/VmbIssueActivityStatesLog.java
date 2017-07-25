package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_issue_activity_states_log")
public class VmbIssueActivityStatesLog {
    @Id
    private Integer logid;

    private String terminal;

    private Integer accountid;

    private Integer states;

    private Integer studyplanid;

    private Integer issueid;

    private Integer learningactivityid;

    private Date createtime;

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
     * @return studyplanid
     */
    public Integer getStudyplanid() {
        return studyplanid;
    }

    /**
     * @param studyplanid
     */
    public void setStudyplanid(Integer studyplanid) {
        this.studyplanid = studyplanid;
    }

    /**
     * @return issueid
     */
    public Integer getIssueid() {
        return issueid;
    }

    /**
     * @param issueid
     */
    public void setIssueid(Integer issueid) {
        this.issueid = issueid;
    }

    /**
     * @return learningactivityid
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * @param learningactivityid
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
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
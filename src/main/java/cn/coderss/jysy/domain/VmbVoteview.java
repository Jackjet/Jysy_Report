package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_voteview")
public class VmbVoteview {
    @Id
    private Integer voteviewid;

    private Integer accountid;

    private Integer voteitemid;

    private Date votetime;

    private Integer learningactivityid;

    private Integer votesolutionid;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * @return voteviewid
     */
    public Integer getVoteviewid() {
        return voteviewid;
    }

    /**
     * @param voteviewid
     */
    public void setVoteviewid(Integer voteviewid) {
        this.voteviewid = voteviewid;
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
     * @return voteitemid
     */
    public Integer getVoteitemid() {
        return voteitemid;
    }

    /**
     * @param voteitemid
     */
    public void setVoteitemid(Integer voteitemid) {
        this.voteitemid = voteitemid;
    }

    /**
     * @return votetime
     */
    public Date getVotetime() {
        return votetime;
    }

    /**
     * @param votetime
     */
    public void setVotetime(Date votetime) {
        this.votetime = votetime;
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
     * @return votesolutionid
     */
    public Integer getVotesolutionid() {
        return votesolutionid;
    }

    /**
     * @param votesolutionid
     */
    public void setVotesolutionid(Integer votesolutionid) {
        this.votesolutionid = votesolutionid;
    }

    /**
     * @return collegeId
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
     * @return enterpriseId
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
}
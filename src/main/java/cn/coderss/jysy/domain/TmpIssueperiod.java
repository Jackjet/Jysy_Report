package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "tmp_issueperiod")
public class TmpIssueperiod {
    private Integer iaactivityid;

    private Integer issueid;

    private Integer accountid;

    private Integer laid;

    private Float periods;

    @Column(name = "min_period")
    private Float minPeriod;

    /**
     * @return iaactivityid
     */
    public Integer getIaactivityid() {
        return iaactivityid;
    }

    /**
     * @param iaactivityid
     */
    public void setIaactivityid(Integer iaactivityid) {
        this.iaactivityid = iaactivityid;
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
     * @return laid
     */
    public Integer getLaid() {
        return laid;
    }

    /**
     * @param laid
     */
    public void setLaid(Integer laid) {
        this.laid = laid;
    }

    /**
     * @return periods
     */
    public Float getPeriods() {
        return periods;
    }

    /**
     * @param periods
     */
    public void setPeriods(Float periods) {
        this.periods = periods;
    }

    /**
     * @return min_period
     */
    public Float getMinPeriod() {
        return minPeriod;
    }

    /**
     * @param minPeriod
     */
    public void setMinPeriod(Float minPeriod) {
        this.minPeriod = minPeriod;
    }
}
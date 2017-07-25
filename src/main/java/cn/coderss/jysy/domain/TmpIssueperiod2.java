package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "tmp_issueperiod2")
public class TmpIssueperiod2 {
    private Integer iaactivityid;

    private Integer accountid;

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
}
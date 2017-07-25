package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_distribmember")
public class VmbDistribmember {
    @Id
    @Column(name = "distribMemberId")
    private Integer distribmemberid;

    @Column(name = "solutionId")
    private Integer solutionid;

    @Column(name = "memberId")
    private Integer memberid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * @return distribMemberId
     */
    public Integer getDistribmemberid() {
        return distribmemberid;
    }

    /**
     * @param distribmemberid
     */
    public void setDistribmemberid(Integer distribmemberid) {
        this.distribmemberid = distribmemberid;
    }

    /**
     * @return solutionId
     */
    public Integer getSolutionid() {
        return solutionid;
    }

    /**
     * @param solutionid
     */
    public void setSolutionid(Integer solutionid) {
        this.solutionid = solutionid;
    }

    /**
     * @return memberId
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * @param memberid
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * @return accountId
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
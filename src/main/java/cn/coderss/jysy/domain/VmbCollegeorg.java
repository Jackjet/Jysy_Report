package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_collegeorg")
public class VmbCollegeorg {
    @Id
    @Column(name = "collegeorgId")
    private Integer collegeorgid;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "orgId")
    private Integer orgid;

    /**
     * @return collegeorgId
     */
    public Integer getCollegeorgid() {
        return collegeorgid;
    }

    /**
     * @param collegeorgid
     */
    public void setCollegeorgid(Integer collegeorgid) {
        this.collegeorgid = collegeorgid;
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
     * @return orgId
     */
    public Integer getOrgid() {
        return orgid;
    }

    /**
     * @param orgid
     */
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
}
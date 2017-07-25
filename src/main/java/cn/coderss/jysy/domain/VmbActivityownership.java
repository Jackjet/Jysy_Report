package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_activityownership")
public class VmbActivityownership {
    @Id
    @Column(name = "ownershipId")
    private Integer ownershipid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "collegeId")
    private Integer collegeid;

    private Boolean public;

    private Boolean recommend;

    private Boolean free;

    private Date createtime;

    /**
     * @return ownershipId
     */
    public Integer getOwnershipid() {
        return ownershipid;
    }

    /**
     * @param ownershipid
     */
    public void setOwnershipid(Integer ownershipid) {
        this.ownershipid = ownershipid;
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

    /**
     * @return learningActivityId
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
     * @return public
     */
    public Boolean getPublic() {
        return public;
    }

    /**
     * @param public
     */
    public void setPublic(Boolean public) {
        this.public = public;
    }

    /**
     * @return recommend
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * @return free
     */
    public Boolean getFree() {
        return free;
    }

    /**
     * @param free
     */
    public void setFree(Boolean free) {
        this.free = free;
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
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_orgactivitydelivery")
public class VmbOrgactivitydelivery {
    @Id
    @Column(name = "deliveryId")
    private Integer deliveryid;

    @Column(name = "memberId")
    private Integer memberid;

    @Column(name = "enterprisecourseId")
    private Integer enterprisecourseid;

    @Column(name = "collegecourseId")
    private Integer collegecourseid;

    /**
     * 课程分配类型（必修，选修）
     */
    private Integer catalog;

    /**
     * @return deliveryId
     */
    public Integer getDeliveryid() {
        return deliveryid;
    }

    /**
     * @param deliveryid
     */
    public void setDeliveryid(Integer deliveryid) {
        this.deliveryid = deliveryid;
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
     * @return enterprisecourseId
     */
    public Integer getEnterprisecourseid() {
        return enterprisecourseid;
    }

    /**
     * @param enterprisecourseid
     */
    public void setEnterprisecourseid(Integer enterprisecourseid) {
        this.enterprisecourseid = enterprisecourseid;
    }

    /**
     * @return collegecourseId
     */
    public Integer getCollegecourseid() {
        return collegecourseid;
    }

    /**
     * @param collegecourseid
     */
    public void setCollegecourseid(Integer collegecourseid) {
        this.collegecourseid = collegecourseid;
    }

    /**
     * 获取课程分配类型（必修，选修）
     *
     * @return catalog - 课程分配类型（必修，选修）
     */
    public Integer getCatalog() {
        return catalog;
    }

    /**
     * 设置课程分配类型（必修，选修）
     *
     * @param catalog 课程分配类型（必修，选修）
     */
    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_studies")
public class VmbStudies {
    @Id
    @Column(name = "studyId")
    private Integer studyid;

    @Column(name = "courseId")
    private Integer courseid;

    @Column(name = "orderdetailId")
    private Integer orderdetailid;

    @Column(name = "accountId")
    private Integer accountid;

    private Date createtime;

    /**
     * @return studyId
     */
    public Integer getStudyid() {
        return studyid;
    }

    /**
     * @param studyid
     */
    public void setStudyid(Integer studyid) {
        this.studyid = studyid;
    }

    /**
     * @return courseId
     */
    public Integer getCourseid() {
        return courseid;
    }

    /**
     * @param courseid
     */
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    /**
     * @return orderdetailId
     */
    public Integer getOrderdetailid() {
        return orderdetailid;
    }

    /**
     * @param orderdetailid
     */
    public void setOrderdetailid(Integer orderdetailid) {
        this.orderdetailid = orderdetailid;
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
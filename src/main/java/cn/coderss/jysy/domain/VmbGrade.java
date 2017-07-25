package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_grade")
public class VmbGrade {
    @Id
    @Column(name = "gradeId")
    private Integer gradeid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    @Column(name = "accountId")
    private Integer accountid;

    /**
     * 等级
     */
    private Integer grade;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * @return gradeId
     */
    public Integer getGradeid() {
        return gradeid;
    }

    /**
     * @param gradeid
     */
    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
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
     * 获取等级
     *
     * @return grade - 等级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置等级
     *
     * @param grade 等级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
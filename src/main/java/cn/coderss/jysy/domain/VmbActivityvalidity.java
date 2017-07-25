package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_activityvalidity")
public class VmbActivityvalidity {
    /**
     * 主键
     */
    @Id
    private Integer validityid;

    private Integer learningactivityid;

    private Integer collegeid;

    private Integer enterpriseid;

    private Date starttime;

    private Date endtime;

    private Date createtime;

    /**
     * 是否有效
     */
    private Integer valid;

    /**
     * 是否长期 1长期0有效时间
     */
    private Integer islongtime;

    /**
     * 获取主键
     *
     * @return validityid - 主键
     */
    public Integer getValidityid() {
        return validityid;
    }

    /**
     * 设置主键
     *
     * @param validityid 主键
     */
    public void setValidityid(Integer validityid) {
        this.validityid = validityid;
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
     * @return collegeid
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
     * @return enterpriseid
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
     * @return starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * @param starttime
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * @return endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    /**
     * 获取是否有效
     *
     * @return valid - 是否有效
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 设置是否有效
     *
     * @param valid 是否有效
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * 获取是否长期 1长期0有效时间
     *
     * @return islongtime - 是否长期 1长期0有效时间
     */
    public Integer getIslongtime() {
        return islongtime;
    }

    /**
     * 设置是否长期 1长期0有效时间
     *
     * @param islongtime 是否长期 1长期0有效时间
     */
    public void setIslongtime(Integer islongtime) {
        this.islongtime = islongtime;
    }
}
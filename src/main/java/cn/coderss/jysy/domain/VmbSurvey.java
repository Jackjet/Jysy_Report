package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_survey")
public class VmbSurvey {
    @Id
    @Column(name = "surveyId")
    private Integer surveyid;

    /**
     * 调查标题
     */
    private String name;

    /**
     * 调查介绍
     */
    private String description;

    /**
     * 开始时间
     */
    private Date starttime;

    /**
     * 结束时间
     */
    private Date endtime;

    /**
     * 是否允许中断
     */
    private Integer canpause;

    /**
     * 状态（未上架、已上架、已下架）
     */
    private Integer states;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * @return surveyId
     */
    public Integer getSurveyid() {
        return surveyid;
    }

    /**
     * @param surveyid
     */
    public void setSurveyid(Integer surveyid) {
        this.surveyid = surveyid;
    }

    /**
     * 获取调查标题
     *
     * @return name - 调查标题
     */
    public String getName() {
        return name;
    }

    /**
     * 设置调查标题
     *
     * @param name 调查标题
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取调查介绍
     *
     * @return description - 调查介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置调查介绍
     *
     * @param description 调查介绍
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取开始时间
     *
     * @return starttime - 开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置开始时间
     *
     * @param starttime 开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取结束时间
     *
     * @return endtime - 结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置结束时间
     *
     * @param endtime 结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取是否允许中断
     *
     * @return canpause - 是否允许中断
     */
    public Integer getCanpause() {
        return canpause;
    }

    /**
     * 设置是否允许中断
     *
     * @param canpause 是否允许中断
     */
    public void setCanpause(Integer canpause) {
        this.canpause = canpause;
    }

    /**
     * 获取状态（未上架、已上架、已下架）
     *
     * @return states - 状态（未上架、已上架、已下架）
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置状态（未上架、已上架、已下架）
     *
     * @param states 状态（未上架、已上架、已下架）
     */
    public void setStates(Integer states) {
        this.states = states;
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
}
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_research")
public class VmbResearch {
    @Id
    @Column(name = "researchId")
    private Integer researchid;

    /**
     * 调研所属问卷
     */
    @Column(name = "surveyId")
    private Integer surveyid;

    /**
     * 调研标题
     */
    private String title;

    /**
     * 调研介绍
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
     * LOGO 的 URL
     */
    private String logourl;

    /**
     * 调研状态
     */
    private Integer states;

    /**
     * 调研所属企业
     */
    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 调研所属学院
     */
    @Column(name = "collegeId")
    private Integer collegeid;

    private Byte public;

    private Byte recommend;

    @Column(name = "research_url")
    private String researchUrl;

    /**
     * @return researchId
     */
    public Integer getResearchid() {
        return researchid;
    }

    /**
     * @param researchid
     */
    public void setResearchid(Integer researchid) {
        this.researchid = researchid;
    }

    /**
     * 获取调研所属问卷
     *
     * @return surveyId - 调研所属问卷
     */
    public Integer getSurveyid() {
        return surveyid;
    }

    /**
     * 设置调研所属问卷
     *
     * @param surveyid 调研所属问卷
     */
    public void setSurveyid(Integer surveyid) {
        this.surveyid = surveyid;
    }

    /**
     * 获取调研标题
     *
     * @return title - 调研标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置调研标题
     *
     * @param title 调研标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取调研介绍
     *
     * @return description - 调研介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置调研介绍
     *
     * @param description 调研介绍
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
     * 获取LOGO 的 URL
     *
     * @return logourl - LOGO 的 URL
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * 设置LOGO 的 URL
     *
     * @param logourl LOGO 的 URL
     */
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    /**
     * 获取调研状态
     *
     * @return states - 调研状态
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置调研状态
     *
     * @param states 调研状态
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * 获取调研所属企业
     *
     * @return enterpriseId - 调研所属企业
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * 设置调研所属企业
     *
     * @param enterpriseid 调研所属企业
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * 获取调研所属学院
     *
     * @return collegeId - 调研所属学院
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * 设置调研所属学院
     *
     * @param collegeid 调研所属学院
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * @return public
     */
    public Byte getPublic() {
        return public;
    }

    /**
     * @param public
     */
    public void setPublic(Byte public) {
        this.public = public;
    }

    /**
     * @return recommend
     */
    public Byte getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    /**
     * @return research_url
     */
    public String getResearchUrl() {
        return researchUrl;
    }

    /**
     * @param researchUrl
     */
    public void setResearchUrl(String researchUrl) {
        this.researchUrl = researchUrl;
    }
}
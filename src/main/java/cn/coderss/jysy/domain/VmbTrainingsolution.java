package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_trainingsolution")
public class VmbTrainingsolution {
    @Id
    @Column(name = "trainingSolutionId")
    private Integer trainingsolutionid;

    /**
     * 教学方案名称
     */
    private String name;

    /**
     * 教学方案简介
     */
    private String description;

    /**
     * 预览视频
     */
    @Column(name = "previewVideoUrl")
    private String previewvideourl;

    /**
     * 所属企业
     */
    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 所属学院
     */
    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * @return trainingSolutionId
     */
    public Integer getTrainingsolutionid() {
        return trainingsolutionid;
    }

    /**
     * @param trainingsolutionid
     */
    public void setTrainingsolutionid(Integer trainingsolutionid) {
        this.trainingsolutionid = trainingsolutionid;
    }

    /**
     * 获取教学方案名称
     *
     * @return name - 教学方案名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置教学方案名称
     *
     * @param name 教学方案名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取教学方案简介
     *
     * @return description - 教学方案简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置教学方案简介
     *
     * @param description 教学方案简介
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取预览视频
     *
     * @return previewVideoUrl - 预览视频
     */
    public String getPreviewvideourl() {
        return previewvideourl;
    }

    /**
     * 设置预览视频
     *
     * @param previewvideourl 预览视频
     */
    public void setPreviewvideourl(String previewvideourl) {
        this.previewvideourl = previewvideourl;
    }

    /**
     * 获取所属企业
     *
     * @return enterpriseId - 所属企业
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * 设置所属企业
     *
     * @param enterpriseid 所属企业
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * 获取所属学院
     *
     * @return collegeId - 所属学院
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * 设置所属学院
     *
     * @param collegeid 所属学院
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }
}
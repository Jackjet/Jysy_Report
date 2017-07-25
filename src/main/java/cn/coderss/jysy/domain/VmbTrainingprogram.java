package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_trainingprogram")
public class VmbTrainingprogram {
    @Id
    @Column(name = "trainingProgramId")
    private Integer trainingprogramid;

    /**
     * 所属教学方案
     */
    @Column(name = "trainingSolutionId")
    private Integer trainingsolutionid;

    /**
     * 所需关联的对象（考试、调研）Id
     */
    @Column(name = "relationshipId")
    private Integer relationshipid;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序号
     */
    @Column(name = "orderIndex")
    private Integer orderindex;

    /**
     * 课程时长（单位：分钟）
     */
    private Integer duration;

    /**
     * 教学方式（考试、调研、课程）
     */
    @Column(name = "teachingMethod")
    private Integer teachingmethod;

    /**
     * 是否需要签到
     */
    @Column(name = "mustCheckIn")
    private Boolean mustcheckin;

    /**
     * @return trainingProgramId
     */
    public Integer getTrainingprogramid() {
        return trainingprogramid;
    }

    /**
     * @param trainingprogramid
     */
    public void setTrainingprogramid(Integer trainingprogramid) {
        this.trainingprogramid = trainingprogramid;
    }

    /**
     * 获取所属教学方案
     *
     * @return trainingSolutionId - 所属教学方案
     */
    public Integer getTrainingsolutionid() {
        return trainingsolutionid;
    }

    /**
     * 设置所属教学方案
     *
     * @param trainingsolutionid 所属教学方案
     */
    public void setTrainingsolutionid(Integer trainingsolutionid) {
        this.trainingsolutionid = trainingsolutionid;
    }

    /**
     * 获取所需关联的对象（考试、调研）Id
     *
     * @return relationshipId - 所需关联的对象（考试、调研）Id
     */
    public Integer getRelationshipid() {
        return relationshipid;
    }

    /**
     * 设置所需关联的对象（考试、调研）Id
     *
     * @param relationshipid 所需关联的对象（考试、调研）Id
     */
    public void setRelationshipid(Integer relationshipid) {
        this.relationshipid = relationshipid;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取排序号
     *
     * @return orderIndex - 排序号
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * 设置排序号
     *
     * @param orderindex 排序号
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * 获取课程时长（单位：分钟）
     *
     * @return duration - 课程时长（单位：分钟）
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 设置课程时长（单位：分钟）
     *
     * @param duration 课程时长（单位：分钟）
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 获取教学方式（考试、调研、课程）
     *
     * @return teachingMethod - 教学方式（考试、调研、课程）
     */
    public Integer getTeachingmethod() {
        return teachingmethod;
    }

    /**
     * 设置教学方式（考试、调研、课程）
     *
     * @param teachingmethod 教学方式（考试、调研、课程）
     */
    public void setTeachingmethod(Integer teachingmethod) {
        this.teachingmethod = teachingmethod;
    }

    /**
     * 获取是否需要签到
     *
     * @return mustCheckIn - 是否需要签到
     */
    public Boolean getMustcheckin() {
        return mustcheckin;
    }

    /**
     * 设置是否需要签到
     *
     * @param mustcheckin 是否需要签到
     */
    public void setMustcheckin(Boolean mustcheckin) {
        this.mustcheckin = mustcheckin;
    }
}
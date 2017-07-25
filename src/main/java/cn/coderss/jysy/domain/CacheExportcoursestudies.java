package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_exportcoursestudies")
public class CacheExportcoursestudies {
    @Id
    private Integer learningactivityid;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动类型
     */
    private String type;

    /**
     * 是否公开
     */
    private String public;

    /**
     * 学习人数
     */
    private Integer accountcount;

    /**
     * 总学习次数
     */
    private Integer studycount;

    /**
     * 分配人数
     */
    private Integer distribcount;

    /**
     * 总学习时长（单位秒）
     */
    private Integer duration;

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
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取活动类型
     *
     * @return type - 活动类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置活动类型
     *
     * @param type 活动类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取是否公开
     *
     * @return public - 是否公开
     */
    public String getPublic() {
        return public;
    }

    /**
     * 设置是否公开
     *
     * @param public 是否公开
     */
    public void setPublic(String public) {
        this.public = public;
    }

    /**
     * 获取学习人数
     *
     * @return accountcount - 学习人数
     */
    public Integer getAccountcount() {
        return accountcount;
    }

    /**
     * 设置学习人数
     *
     * @param accountcount 学习人数
     */
    public void setAccountcount(Integer accountcount) {
        this.accountcount = accountcount;
    }

    /**
     * 获取总学习次数
     *
     * @return studycount - 总学习次数
     */
    public Integer getStudycount() {
        return studycount;
    }

    /**
     * 设置总学习次数
     *
     * @param studycount 总学习次数
     */
    public void setStudycount(Integer studycount) {
        this.studycount = studycount;
    }

    /**
     * 获取分配人数
     *
     * @return distribcount - 分配人数
     */
    public Integer getDistribcount() {
        return distribcount;
    }

    /**
     * 设置分配人数
     *
     * @param distribcount 分配人数
     */
    public void setDistribcount(Integer distribcount) {
        this.distribcount = distribcount;
    }

    /**
     * 获取总学习时长（单位秒）
     *
     * @return duration - 总学习时长（单位秒）
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 设置总学习时长（单位秒）
     *
     * @param duration 总学习时长（单位秒）
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
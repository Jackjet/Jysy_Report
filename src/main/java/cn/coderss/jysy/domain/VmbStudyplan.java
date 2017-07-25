package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_studyplan")
public class VmbStudyplan {
    @Id
    private Integer learningactivityid;

    /**
     * 过期后是否能继续学习，1为能，0为不能
     */
    @Column(name = "is_continue")
    private Integer isContinue;

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
     * 获取过期后是否能继续学习，1为能，0为不能
     *
     * @return is_continue - 过期后是否能继续学习，1为能，0为不能
     */
    public Integer getIsContinue() {
        return isContinue;
    }

    /**
     * 设置过期后是否能继续学习，1为能，0为不能
     *
     * @param isContinue 过期后是否能继续学习，1为能，0为不能
     */
    public void setIsContinue(Integer isContinue) {
        this.isContinue = isContinue;
    }
}
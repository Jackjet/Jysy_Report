package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_activityterminal")
public class VmbActivityterminal {
    /**
     * 学习活动ID
     */
    @Id
    private Integer learningactivityid;

    @Id
    private Integer terminal;

    /**
     * 创建的时间
     */
    private Date createtime;

    /**
     * 获取学习活动ID
     *
     * @return learningactivityid - 学习活动ID
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置学习活动ID
     *
     * @param learningactivityid 学习活动ID
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * @return terminal
     */
    public Integer getTerminal() {
        return terminal;
    }

    /**
     * @param terminal
     */
    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    /**
     * 获取创建的时间
     *
     * @return createtime - 创建的时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建的时间
     *
     * @param createtime 创建的时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
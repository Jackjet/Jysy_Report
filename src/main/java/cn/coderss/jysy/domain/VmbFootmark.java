package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_footmark")
public class VmbFootmark {
    @Id
    @Column(name = "footmarkId")
    private Integer footmarkid;

    @Column(name = "accountId")
    private Integer accountid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    private Date createtime;

    /**
     * @return footmarkId
     */
    public Integer getFootmarkid() {
        return footmarkid;
    }

    /**
     * @param footmarkid
     */
    public void setFootmarkid(Integer footmarkid) {
        this.footmarkid = footmarkid;
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
package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cache_collegeactivity")
public class CacheCollegeactivity {
    @Id
    private Integer collegeid;

    @Id
    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    private Byte public;

    private Byte recommend;

    private Date createtime;

    private Integer orderindex;

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
     * @return orderindex
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }
}
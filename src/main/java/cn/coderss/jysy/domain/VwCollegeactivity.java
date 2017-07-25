package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_collegeactivity")
public class VwCollegeactivity {
    @Column(name = "collegeId")
    private Byte collegeid;

    @Column(name = "learningActivityId")
    private Byte learningactivityid;

    private Byte public;

    private Byte recommend;

    private Byte createtime;

    private Byte orderindex;

    /**
     * @return collegeId
     */
    public Byte getCollegeid() {
        return collegeid;
    }

    /**
     * @param collegeid
     */
    public void setCollegeid(Byte collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * @return learningActivityId
     */
    public Byte getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * @param learningactivityid
     */
    public void setLearningactivityid(Byte learningactivityid) {
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
    public Byte getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Byte createtime) {
        this.createtime = createtime;
    }

    /**
     * @return orderindex
     */
    public Byte getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Byte orderindex) {
        this.orderindex = orderindex;
    }
}
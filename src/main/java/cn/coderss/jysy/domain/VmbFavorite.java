package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_favorite")
public class VmbFavorite {
    @Id
    @Column(name = "favoriteId")
    private Integer favoriteid;

    @Column(name = "accountId")
    private Integer accountid;

    @Column(name = "learningActivityId")
    private Integer learningactivityid;

    private Date createtime;

    /**
     * @return favoriteId
     */
    public Integer getFavoriteid() {
        return favoriteid;
    }

    /**
     * @param favoriteid
     */
    public void setFavoriteid(Integer favoriteid) {
        this.favoriteid = favoriteid;
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
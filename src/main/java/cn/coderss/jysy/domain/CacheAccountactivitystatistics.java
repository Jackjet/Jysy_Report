package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cache_accountactivitystatistics")
public class CacheAccountactivitystatistics {
    @Id
    private Integer accountid;

    @Id
    private Integer collegeid;

    private Integer destcount;

    private Integer completedcount;

    private Long studysecond;

    private Date lastlogin;

    /**
     * 未学习数量
     */
    private Integer unlearnedcount;

    private Date laststudytime;

    /**
     * @return accountid
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
     * @return destcount
     */
    public Integer getDestcount() {
        return destcount;
    }

    /**
     * @param destcount
     */
    public void setDestcount(Integer destcount) {
        this.destcount = destcount;
    }

    /**
     * @return completedcount
     */
    public Integer getCompletedcount() {
        return completedcount;
    }

    /**
     * @param completedcount
     */
    public void setCompletedcount(Integer completedcount) {
        this.completedcount = completedcount;
    }

    /**
     * @return studysecond
     */
    public Long getStudysecond() {
        return studysecond;
    }

    /**
     * @param studysecond
     */
    public void setStudysecond(Long studysecond) {
        this.studysecond = studysecond;
    }

    /**
     * @return lastlogin
     */
    public Date getLastlogin() {
        return lastlogin;
    }

    /**
     * @param lastlogin
     */
    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    /**
     * 获取未学习数量
     *
     * @return unlearnedcount - 未学习数量
     */
    public Integer getUnlearnedcount() {
        return unlearnedcount;
    }

    /**
     * 设置未学习数量
     *
     * @param unlearnedcount 未学习数量
     */
    public void setUnlearnedcount(Integer unlearnedcount) {
        this.unlearnedcount = unlearnedcount;
    }

    /**
     * @return laststudytime
     */
    public Date getLaststudytime() {
        return laststudytime;
    }

    /**
     * @param laststudytime
     */
    public void setLaststudytime(Date laststudytime) {
        this.laststudytime = laststudytime;
    }
}
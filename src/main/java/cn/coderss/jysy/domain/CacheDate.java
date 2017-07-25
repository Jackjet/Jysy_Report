package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cache_date")
public class CacheDate {
    @Id
    private Date date;

    @Column(name = "acc_count")
    private Long accCount;

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return acc_count
     */
    public Long getAccCount() {
        return accCount;
    }

    /**
     * @param accCount
     */
    public void setAccCount(Long accCount) {
        this.accCount = accCount;
    }
}
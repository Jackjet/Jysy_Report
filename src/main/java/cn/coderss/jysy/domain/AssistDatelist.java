package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "assist_datelist")
public class AssistDatelist {
    @Id
    private Date datevalue;

    /**
     * @return datevalue
     */
    public Date getDatevalue() {
        return datevalue;
    }

    /**
     * @param datevalue
     */
    public void setDatevalue(Date datevalue) {
        this.datevalue = datevalue;
    }
}
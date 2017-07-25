package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_collegeconfig")
public class VmbCollegeconfig {
    @Id
    private Integer collegeid;

    private Integer hasbbs;

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
     * @return hasbbs
     */
    public Integer getHasbbs() {
        return hasbbs;
    }

    /**
     * @param hasbbs
     */
    public void setHasbbs(Integer hasbbs) {
        this.hasbbs = hasbbs;
    }
}
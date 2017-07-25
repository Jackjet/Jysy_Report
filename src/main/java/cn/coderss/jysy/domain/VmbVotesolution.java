package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_votesolution")
public class VmbVotesolution {
    @Id
    private Integer votesolutionid;

    private String title;

    private String description;

    private Integer enterpriseid;

    private Integer collegeid;

    private Integer ismustclick;

    private Integer ismultipleclicks;

    private Integer isdeffclicks;

    /**
     * @return votesolutionid
     */
    public Integer getVotesolutionid() {
        return votesolutionid;
    }

    /**
     * @param votesolutionid
     */
    public void setVotesolutionid(Integer votesolutionid) {
        this.votesolutionid = votesolutionid;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return enterpriseid
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
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
     * @return ismustclick
     */
    public Integer getIsmustclick() {
        return ismustclick;
    }

    /**
     * @param ismustclick
     */
    public void setIsmustclick(Integer ismustclick) {
        this.ismustclick = ismustclick;
    }

    /**
     * @return ismultipleclicks
     */
    public Integer getIsmultipleclicks() {
        return ismultipleclicks;
    }

    /**
     * @param ismultipleclicks
     */
    public void setIsmultipleclicks(Integer ismultipleclicks) {
        this.ismultipleclicks = ismultipleclicks;
    }

    /**
     * @return isdeffclicks
     */
    public Integer getIsdeffclicks() {
        return isdeffclicks;
    }

    /**
     * @param isdeffclicks
     */
    public void setIsdeffclicks(Integer isdeffclicks) {
        this.isdeffclicks = isdeffclicks;
    }
}
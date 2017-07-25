package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "cache_accountexamination")
public class CacheAccountexamination {
    @Id
    private Integer accountexamid;

    private Integer accountid;

    private Integer examinationid;

    private Integer totalscore;

    private Integer passscore;

    private Integer score;

    private Integer ispass;

    /**
     * @return accountexamid
     */
    public Integer getAccountexamid() {
        return accountexamid;
    }

    /**
     * @param accountexamid
     */
    public void setAccountexamid(Integer accountexamid) {
        this.accountexamid = accountexamid;
    }

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
     * @return examinationid
     */
    public Integer getExaminationid() {
        return examinationid;
    }

    /**
     * @param examinationid
     */
    public void setExaminationid(Integer examinationid) {
        this.examinationid = examinationid;
    }

    /**
     * @return totalscore
     */
    public Integer getTotalscore() {
        return totalscore;
    }

    /**
     * @param totalscore
     */
    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    /**
     * @return passscore
     */
    public Integer getPassscore() {
        return passscore;
    }

    /**
     * @param passscore
     */
    public void setPassscore(Integer passscore) {
        this.passscore = passscore;
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return ispass
     */
    public Integer getIspass() {
        return ispass;
    }

    /**
     * @param ispass
     */
    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }
}
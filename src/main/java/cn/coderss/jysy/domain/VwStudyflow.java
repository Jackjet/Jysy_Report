package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vw_studyflow")
public class VwStudyflow {
    @Column(name = "recordeId")
    private Byte recordeid;

    @Column(name = "studyId")
    private Byte studyid;

    private Byte learningactivityid;

    private Byte chapterid;

    private Byte starttime;

    private Byte endtime;

    private Byte exitstates;

    private Byte duration;

    private Byte overed;

    private Byte score;

    private Byte accountid;

    private Byte progress;

    private Byte startduration;

    private Byte physicendtime;

    private Byte terminal;

    private Byte ending;

    private Byte collegeid;

    private Byte enterpriseid;

    private Byte sucessfuled;

    private Byte sumduration;

    /**
     * @return recordeId
     */
    public Byte getRecordeid() {
        return recordeid;
    }

    /**
     * @param recordeid
     */
    public void setRecordeid(Byte recordeid) {
        this.recordeid = recordeid;
    }

    /**
     * @return studyId
     */
    public Byte getStudyid() {
        return studyid;
    }

    /**
     * @param studyid
     */
    public void setStudyid(Byte studyid) {
        this.studyid = studyid;
    }

    /**
     * @return learningactivityid
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
     * @return chapterid
     */
    public Byte getChapterid() {
        return chapterid;
    }

    /**
     * @param chapterid
     */
    public void setChapterid(Byte chapterid) {
        this.chapterid = chapterid;
    }

    /**
     * @return starttime
     */
    public Byte getStarttime() {
        return starttime;
    }

    /**
     * @param starttime
     */
    public void setStarttime(Byte starttime) {
        this.starttime = starttime;
    }

    /**
     * @return endtime
     */
    public Byte getEndtime() {
        return endtime;
    }

    /**
     * @param endtime
     */
    public void setEndtime(Byte endtime) {
        this.endtime = endtime;
    }

    /**
     * @return exitstates
     */
    public Byte getExitstates() {
        return exitstates;
    }

    /**
     * @param exitstates
     */
    public void setExitstates(Byte exitstates) {
        this.exitstates = exitstates;
    }

    /**
     * @return duration
     */
    public Byte getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Byte duration) {
        this.duration = duration;
    }

    /**
     * @return overed
     */
    public Byte getOvered() {
        return overed;
    }

    /**
     * @param overed
     */
    public void setOvered(Byte overed) {
        this.overed = overed;
    }

    /**
     * @return score
     */
    public Byte getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Byte score) {
        this.score = score;
    }

    /**
     * @return accountid
     */
    public Byte getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Byte accountid) {
        this.accountid = accountid;
    }

    /**
     * @return progress
     */
    public Byte getProgress() {
        return progress;
    }

    /**
     * @param progress
     */
    public void setProgress(Byte progress) {
        this.progress = progress;
    }

    /**
     * @return startduration
     */
    public Byte getStartduration() {
        return startduration;
    }

    /**
     * @param startduration
     */
    public void setStartduration(Byte startduration) {
        this.startduration = startduration;
    }

    /**
     * @return physicendtime
     */
    public Byte getPhysicendtime() {
        return physicendtime;
    }

    /**
     * @param physicendtime
     */
    public void setPhysicendtime(Byte physicendtime) {
        this.physicendtime = physicendtime;
    }

    /**
     * @return terminal
     */
    public Byte getTerminal() {
        return terminal;
    }

    /**
     * @param terminal
     */
    public void setTerminal(Byte terminal) {
        this.terminal = terminal;
    }

    /**
     * @return ending
     */
    public Byte getEnding() {
        return ending;
    }

    /**
     * @param ending
     */
    public void setEnding(Byte ending) {
        this.ending = ending;
    }

    /**
     * @return collegeid
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
     * @return enterpriseid
     */
    public Byte getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * @param enterpriseid
     */
    public void setEnterpriseid(Byte enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * @return sucessfuled
     */
    public Byte getSucessfuled() {
        return sucessfuled;
    }

    /**
     * @param sucessfuled
     */
    public void setSucessfuled(Byte sucessfuled) {
        this.sucessfuled = sucessfuled;
    }

    /**
     * @return sumduration
     */
    public Byte getSumduration() {
        return sumduration;
    }

    /**
     * @param sumduration
     */
    public void setSumduration(Byte sumduration) {
        this.sumduration = sumduration;
    }
}
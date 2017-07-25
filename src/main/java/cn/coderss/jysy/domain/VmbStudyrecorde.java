package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_studyrecorde")
public class VmbStudyrecorde {
    @Id
    @Column(name = "recordeId")
    private Long recordeid;

    @Column(name = "studyId")
    private Integer studyid;

    /**
     * 课程Id
     */
    private Integer learningactivityid;

    /**
     * 系列课程：章节Id
scorm：scormid
other：0
     */
    private Integer chapterid;

    /**
     * 本次学习的开始时间
     */
    private Date starttime;

    /**
     * 本次学习结束时间
     */
    private Date endtime;

    /**
     * 退出方式（正常退出，异常退出，超时退出）
     */
    private Integer exitstates;

    private Integer duration;

    private Integer overed;

    private Float score;

    /**
     * 用户Id
     */
    private Integer accountid;

    private Integer progress;

    private Integer startduration;

    /**
     * 物理结束时间
     */
    private Date physicendtime;

    /**
     * 终端信息
     */
    private String terminal;

    private String ending;

    private Integer collegeid;

    private Integer enterpriseid;

    private Integer sucessfuled;

    private Integer sectionsid;

    /**
     * 学习记录生产方式
     */
    private Integer recordingmode;

    /**
     * 记录创建时间
     */
    private Date createtime;

    /**
     * 历史修改版本
     */
    private Integer originalrecordeid;

    /**
     * 最后修改时间
     */
    private Date lastupdatetime;

    /**
     * 创建记录的用户ID
     */
    private Integer createaccountid;

    /**
     * 学习记录是否有效
     */
    private Integer valid;

    /**
     * 最后修改记录的用户ID
     */
    private Integer lastupdateaccountid;

    /**
     * 学习记录类型
     */
    private Integer recordetype;

    /**
     * 学员证书编号
     */
    @Column(name = "certificate_code")
    private String certificateCode;

    /**
     * @return recordeId
     */
    public Long getRecordeid() {
        return recordeid;
    }

    /**
     * @param recordeid
     */
    public void setRecordeid(Long recordeid) {
        this.recordeid = recordeid;
    }

    /**
     * @return studyId
     */
    public Integer getStudyid() {
        return studyid;
    }

    /**
     * @param studyid
     */
    public void setStudyid(Integer studyid) {
        this.studyid = studyid;
    }

    /**
     * 获取课程Id
     *
     * @return learningactivityid - 课程Id
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置课程Id
     *
     * @param learningactivityid 课程Id
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取系列课程：章节Id
scorm：scormid
other：0
     *
     * @return chapterid - 系列课程：章节Id
scorm：scormid
other：0
     */
    public Integer getChapterid() {
        return chapterid;
    }

    /**
     * 设置系列课程：章节Id
scorm：scormid
other：0
     *
     * @param chapterid 系列课程：章节Id
scorm：scormid
other：0
     */
    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    /**
     * 获取本次学习的开始时间
     *
     * @return starttime - 本次学习的开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置本次学习的开始时间
     *
     * @param starttime 本次学习的开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取本次学习结束时间
     *
     * @return endtime - 本次学习结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置本次学习结束时间
     *
     * @param endtime 本次学习结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取退出方式（正常退出，异常退出，超时退出）
     *
     * @return exitstates - 退出方式（正常退出，异常退出，超时退出）
     */
    public Integer getExitstates() {
        return exitstates;
    }

    /**
     * 设置退出方式（正常退出，异常退出，超时退出）
     *
     * @param exitstates 退出方式（正常退出，异常退出，超时退出）
     */
    public void setExitstates(Integer exitstates) {
        this.exitstates = exitstates;
    }

    /**
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return overed
     */
    public Integer getOvered() {
        return overed;
    }

    /**
     * @param overed
     */
    public void setOvered(Integer overed) {
        this.overed = overed;
    }

    /**
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 获取用户Id
     *
     * @return accountid - 用户Id
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * 设置用户Id
     *
     * @param accountid 用户Id
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * @return progress
     */
    public Integer getProgress() {
        return progress;
    }

    /**
     * @param progress
     */
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    /**
     * @return startduration
     */
    public Integer getStartduration() {
        return startduration;
    }

    /**
     * @param startduration
     */
    public void setStartduration(Integer startduration) {
        this.startduration = startduration;
    }

    /**
     * 获取物理结束时间
     *
     * @return physicendtime - 物理结束时间
     */
    public Date getPhysicendtime() {
        return physicendtime;
    }

    /**
     * 设置物理结束时间
     *
     * @param physicendtime 物理结束时间
     */
    public void setPhysicendtime(Date physicendtime) {
        this.physicendtime = physicendtime;
    }

    /**
     * 获取终端信息
     *
     * @return terminal - 终端信息
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * 设置终端信息
     *
     * @param terminal 终端信息
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * @return ending
     */
    public String getEnding() {
        return ending;
    }

    /**
     * @param ending
     */
    public void setEnding(String ending) {
        this.ending = ending;
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
     * @return sucessfuled
     */
    public Integer getSucessfuled() {
        return sucessfuled;
    }

    /**
     * @param sucessfuled
     */
    public void setSucessfuled(Integer sucessfuled) {
        this.sucessfuled = sucessfuled;
    }

    /**
     * @return sectionsid
     */
    public Integer getSectionsid() {
        return sectionsid;
    }

    /**
     * @param sectionsid
     */
    public void setSectionsid(Integer sectionsid) {
        this.sectionsid = sectionsid;
    }

    /**
     * 获取学习记录生产方式
     *
     * @return recordingmode - 学习记录生产方式
     */
    public Integer getRecordingmode() {
        return recordingmode;
    }

    /**
     * 设置学习记录生产方式
     *
     * @param recordingmode 学习记录生产方式
     */
    public void setRecordingmode(Integer recordingmode) {
        this.recordingmode = recordingmode;
    }

    /**
     * 获取记录创建时间
     *
     * @return createtime - 记录创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置记录创建时间
     *
     * @param createtime 记录创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取历史修改版本
     *
     * @return originalrecordeid - 历史修改版本
     */
    public Integer getOriginalrecordeid() {
        return originalrecordeid;
    }

    /**
     * 设置历史修改版本
     *
     * @param originalrecordeid 历史修改版本
     */
    public void setOriginalrecordeid(Integer originalrecordeid) {
        this.originalrecordeid = originalrecordeid;
    }

    /**
     * 获取最后修改时间
     *
     * @return lastupdatetime - 最后修改时间
     */
    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    /**
     * 设置最后修改时间
     *
     * @param lastupdatetime 最后修改时间
     */
    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    /**
     * 获取创建记录的用户ID
     *
     * @return createaccountid - 创建记录的用户ID
     */
    public Integer getCreateaccountid() {
        return createaccountid;
    }

    /**
     * 设置创建记录的用户ID
     *
     * @param createaccountid 创建记录的用户ID
     */
    public void setCreateaccountid(Integer createaccountid) {
        this.createaccountid = createaccountid;
    }

    /**
     * 获取学习记录是否有效
     *
     * @return valid - 学习记录是否有效
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 设置学习记录是否有效
     *
     * @param valid 学习记录是否有效
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * 获取最后修改记录的用户ID
     *
     * @return lastupdateaccountid - 最后修改记录的用户ID
     */
    public Integer getLastupdateaccountid() {
        return lastupdateaccountid;
    }

    /**
     * 设置最后修改记录的用户ID
     *
     * @param lastupdateaccountid 最后修改记录的用户ID
     */
    public void setLastupdateaccountid(Integer lastupdateaccountid) {
        this.lastupdateaccountid = lastupdateaccountid;
    }

    /**
     * 获取学习记录类型
     *
     * @return recordetype - 学习记录类型
     */
    public Integer getRecordetype() {
        return recordetype;
    }

    /**
     * 设置学习记录类型
     *
     * @param recordetype 学习记录类型
     */
    public void setRecordetype(Integer recordetype) {
        this.recordetype = recordetype;
    }

    /**
     * 获取学员证书编号
     *
     * @return certificate_code - 学员证书编号
     */
    public String getCertificateCode() {
        return certificateCode;
    }

    /**
     * 设置学员证书编号
     *
     * @param certificateCode 学员证书编号
     */
    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }
}
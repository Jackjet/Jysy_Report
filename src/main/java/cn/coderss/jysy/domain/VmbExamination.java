package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_examination")
public class VmbExamination {
    @Id
    @Column(name = "examinationId")
    private Integer examinationid;

    @Column(name = "paperId")
    private Integer paperid;

    @Column(name = "collegeId")
    private Integer collegeid;

    @Column(name = "enterpriseId")
    private Integer enterpriseid;

    /**
     * 考试标题
     */
    private String title;

    /**
     * 考试开始时间
     */
    private Date starttime;

    /**
     * 考试结束时间
     */
    private Date endtime;

    /**
     * 考试总时长（单位：分钟）
     */
    private Integer examtime;

    /**
     * 可重复次数
     */
    private Integer repeatcount;

    /**
     * 总分
     */
    private Integer totalscore;

    /**
     * 状态（未上架、已上架、已下架）
     */
    private Integer states;

    /**
     * 是否允许中断
     */
    private Integer canpause;

    /**
     * 及格线成绩
     */
    private Integer passscore;

    @Column(name = "retry_exam")
    private Integer retryExam;

    @Column(name = "view_result")
    private Integer viewResult;

    @Column(name = "show_answer")
    private Integer showAnswer;

    @Column(name = "show_explain")
    private Integer showExplain;

    @Column(name = "exam_time")
    private Integer examTime;

    private Boolean public;

    private Boolean recommend;

    private String description;

    @Column(name = "after_show_answer")
    private Byte afterShowAnswer;

    @Column(name = "after_show_explain")
    private Byte afterShowExplain;

    @Column(name = "can_not_see")
    private Integer canNotSee;

    /**
     * @return examinationId
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
     * @return paperId
     */
    public Integer getPaperid() {
        return paperid;
    }

    /**
     * @param paperid
     */
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    /**
     * @return collegeId
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
     * @return enterpriseId
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
     * 获取考试标题
     *
     * @return title - 考试标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置考试标题
     *
     * @param title 考试标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取考试开始时间
     *
     * @return starttime - 考试开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置考试开始时间
     *
     * @param starttime 考试开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取考试结束时间
     *
     * @return endtime - 考试结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置考试结束时间
     *
     * @param endtime 考试结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取考试总时长（单位：分钟）
     *
     * @return examtime - 考试总时长（单位：分钟）
     */
    public Integer getExamtime() {
        return examtime;
    }

    /**
     * 设置考试总时长（单位：分钟）
     *
     * @param examtime 考试总时长（单位：分钟）
     */
    public void setExamtime(Integer examtime) {
        this.examtime = examtime;
    }

    /**
     * 获取可重复次数
     *
     * @return repeatcount - 可重复次数
     */
    public Integer getRepeatcount() {
        return repeatcount;
    }

    /**
     * 设置可重复次数
     *
     * @param repeatcount 可重复次数
     */
    public void setRepeatcount(Integer repeatcount) {
        this.repeatcount = repeatcount;
    }

    /**
     * 获取总分
     *
     * @return totalscore - 总分
     */
    public Integer getTotalscore() {
        return totalscore;
    }

    /**
     * 设置总分
     *
     * @param totalscore 总分
     */
    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    /**
     * 获取状态（未上架、已上架、已下架）
     *
     * @return states - 状态（未上架、已上架、已下架）
     */
    public Integer getStates() {
        return states;
    }

    /**
     * 设置状态（未上架、已上架、已下架）
     *
     * @param states 状态（未上架、已上架、已下架）
     */
    public void setStates(Integer states) {
        this.states = states;
    }

    /**
     * 获取是否允许中断
     *
     * @return canpause - 是否允许中断
     */
    public Integer getCanpause() {
        return canpause;
    }

    /**
     * 设置是否允许中断
     *
     * @param canpause 是否允许中断
     */
    public void setCanpause(Integer canpause) {
        this.canpause = canpause;
    }

    /**
     * 获取及格线成绩
     *
     * @return passscore - 及格线成绩
     */
    public Integer getPassscore() {
        return passscore;
    }

    /**
     * 设置及格线成绩
     *
     * @param passscore 及格线成绩
     */
    public void setPassscore(Integer passscore) {
        this.passscore = passscore;
    }

    /**
     * @return retry_exam
     */
    public Integer getRetryExam() {
        return retryExam;
    }

    /**
     * @param retryExam
     */
    public void setRetryExam(Integer retryExam) {
        this.retryExam = retryExam;
    }

    /**
     * @return view_result
     */
    public Integer getViewResult() {
        return viewResult;
    }

    /**
     * @param viewResult
     */
    public void setViewResult(Integer viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * @return show_answer
     */
    public Integer getShowAnswer() {
        return showAnswer;
    }

    /**
     * @param showAnswer
     */
    public void setShowAnswer(Integer showAnswer) {
        this.showAnswer = showAnswer;
    }

    /**
     * @return show_explain
     */
    public Integer getShowExplain() {
        return showExplain;
    }

    /**
     * @param showExplain
     */
    public void setShowExplain(Integer showExplain) {
        this.showExplain = showExplain;
    }

    /**
     * @return exam_time
     */
    public Integer getExamTime() {
        return examTime;
    }

    /**
     * @param examTime
     */
    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    /**
     * @return public
     */
    public Boolean getPublic() {
        return public;
    }

    /**
     * @param public
     */
    public void setPublic(Boolean public) {
        this.public = public;
    }

    /**
     * @return recommend
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
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
     * @return after_show_answer
     */
    public Byte getAfterShowAnswer() {
        return afterShowAnswer;
    }

    /**
     * @param afterShowAnswer
     */
    public void setAfterShowAnswer(Byte afterShowAnswer) {
        this.afterShowAnswer = afterShowAnswer;
    }

    /**
     * @return after_show_explain
     */
    public Byte getAfterShowExplain() {
        return afterShowExplain;
    }

    /**
     * @param afterShowExplain
     */
    public void setAfterShowExplain(Byte afterShowExplain) {
        this.afterShowExplain = afterShowExplain;
    }

    /**
     * @return can_not_see
     */
    public Integer getCanNotSee() {
        return canNotSee;
    }

    /**
     * @param canNotSee
     */
    public void setCanNotSee(Integer canNotSee) {
        this.canNotSee = canNotSee;
    }
}
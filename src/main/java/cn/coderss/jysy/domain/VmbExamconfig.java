package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_examconfig")
public class VmbExamconfig {
    /**
     * 配置主键
     */
    @Id
    private Integer configid;

    /**
     * 学习活动ID
     */
    private Integer learningactivityid;

    /**
     * 节点ID,learninginfomationid相连
     */
    private Integer sectionid;

    /**
     * 试卷ID,exampaperid相连
     */
    private Integer paperid;

    /**
     * 学院ID
     */
    private Integer collegeid;

    /**
     * 企业ID
     */
    private Integer enterpriseid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 这个配置谁创建出来的
     */
    private Integer createaccountid;

    /**
     * 考试时长,分钟,
     */
    private Integer examtime;

    /**
     * 通过分数
     */
    private Integer passscore;

    /**
     * 总分
     */
    private Integer totalscore;

    /**
     * 是否可以重复考试0不可以,1可以
     */
    @Column(name = "retry_exam")
    private Integer retryExam;

    /**
     * 重复考试次数
     */
    private Integer repeatcount;

    /**
     * 1:整个考试结束查看答案
0:学员考完就能看
     */
    @Column(name = "after_show_answer")
    private Integer afterShowAnswer;

    /**
     * 1:能看答案
0:不能看答案
     */
    @Column(name = "show_answer")
    private Integer showAnswer;

    /**
     * 是否是时间限定,1有限定,0无限
     */
    @Column(name = "exam_time")
    private Integer examTime;

    /**
     * 是否显示解析,0表示不显示,1表示显示
     */
    @Column(name = "show_explain")
    private Integer showExplain;

    /**
     * 是否考试结束后显示解析,1表示解析后,0表示立马看解析
     */
    @Column(name = "after_show_explain")
    private Integer afterShowExplain;

    /**
     * 是否能看到结果(指分数),0表示不能,1表示能
     */
    @Column(name = "view_result")
    private Integer viewResult;

    /**
     * 获取配置主键
     *
     * @return configid - 配置主键
     */
    public Integer getConfigid() {
        return configid;
    }

    /**
     * 设置配置主键
     *
     * @param configid 配置主键
     */
    public void setConfigid(Integer configid) {
        this.configid = configid;
    }

    /**
     * 获取学习活动ID
     *
     * @return learningactivityid - 学习活动ID
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * 设置学习活动ID
     *
     * @param learningactivityid 学习活动ID
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * 获取节点ID,learninginfomationid相连
     *
     * @return sectionid - 节点ID,learninginfomationid相连
     */
    public Integer getSectionid() {
        return sectionid;
    }

    /**
     * 设置节点ID,learninginfomationid相连
     *
     * @param sectionid 节点ID,learninginfomationid相连
     */
    public void setSectionid(Integer sectionid) {
        this.sectionid = sectionid;
    }

    /**
     * 获取试卷ID,exampaperid相连
     *
     * @return paperid - 试卷ID,exampaperid相连
     */
    public Integer getPaperid() {
        return paperid;
    }

    /**
     * 设置试卷ID,exampaperid相连
     *
     * @param paperid 试卷ID,exampaperid相连
     */
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    /**
     * 获取学院ID
     *
     * @return collegeid - 学院ID
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * 设置学院ID
     *
     * @param collegeid 学院ID
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * 获取企业ID
     *
     * @return enterpriseid - 企业ID
     */
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    /**
     * 设置企业ID
     *
     * @param enterpriseid 企业ID
     */
    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取这个配置谁创建出来的
     *
     * @return createaccountid - 这个配置谁创建出来的
     */
    public Integer getCreateaccountid() {
        return createaccountid;
    }

    /**
     * 设置这个配置谁创建出来的
     *
     * @param createaccountid 这个配置谁创建出来的
     */
    public void setCreateaccountid(Integer createaccountid) {
        this.createaccountid = createaccountid;
    }

    /**
     * 获取考试时长,分钟,
     *
     * @return examtime - 考试时长,分钟,
     */
    public Integer getExamtime() {
        return examtime;
    }

    /**
     * 设置考试时长,分钟,
     *
     * @param examtime 考试时长,分钟,
     */
    public void setExamtime(Integer examtime) {
        this.examtime = examtime;
    }

    /**
     * 获取通过分数
     *
     * @return passscore - 通过分数
     */
    public Integer getPassscore() {
        return passscore;
    }

    /**
     * 设置通过分数
     *
     * @param passscore 通过分数
     */
    public void setPassscore(Integer passscore) {
        this.passscore = passscore;
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
     * 获取是否可以重复考试0不可以,1可以
     *
     * @return retry_exam - 是否可以重复考试0不可以,1可以
     */
    public Integer getRetryExam() {
        return retryExam;
    }

    /**
     * 设置是否可以重复考试0不可以,1可以
     *
     * @param retryExam 是否可以重复考试0不可以,1可以
     */
    public void setRetryExam(Integer retryExam) {
        this.retryExam = retryExam;
    }

    /**
     * 获取重复考试次数
     *
     * @return repeatcount - 重复考试次数
     */
    public Integer getRepeatcount() {
        return repeatcount;
    }

    /**
     * 设置重复考试次数
     *
     * @param repeatcount 重复考试次数
     */
    public void setRepeatcount(Integer repeatcount) {
        this.repeatcount = repeatcount;
    }

    /**
     * 获取1:整个考试结束查看答案
0:学员考完就能看
     *
     * @return after_show_answer - 1:整个考试结束查看答案
0:学员考完就能看
     */
    public Integer getAfterShowAnswer() {
        return afterShowAnswer;
    }

    /**
     * 设置1:整个考试结束查看答案
0:学员考完就能看
     *
     * @param afterShowAnswer 1:整个考试结束查看答案
0:学员考完就能看
     */
    public void setAfterShowAnswer(Integer afterShowAnswer) {
        this.afterShowAnswer = afterShowAnswer;
    }

    /**
     * 获取1:能看答案
0:不能看答案
     *
     * @return show_answer - 1:能看答案
0:不能看答案
     */
    public Integer getShowAnswer() {
        return showAnswer;
    }

    /**
     * 设置1:能看答案
0:不能看答案
     *
     * @param showAnswer 1:能看答案
0:不能看答案
     */
    public void setShowAnswer(Integer showAnswer) {
        this.showAnswer = showAnswer;
    }

    /**
     * 获取是否是时间限定,1有限定,0无限
     *
     * @return exam_time - 是否是时间限定,1有限定,0无限
     */
    public Integer getExamTime() {
        return examTime;
    }

    /**
     * 设置是否是时间限定,1有限定,0无限
     *
     * @param examTime 是否是时间限定,1有限定,0无限
     */
    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    /**
     * 获取是否显示解析,0表示不显示,1表示显示
     *
     * @return show_explain - 是否显示解析,0表示不显示,1表示显示
     */
    public Integer getShowExplain() {
        return showExplain;
    }

    /**
     * 设置是否显示解析,0表示不显示,1表示显示
     *
     * @param showExplain 是否显示解析,0表示不显示,1表示显示
     */
    public void setShowExplain(Integer showExplain) {
        this.showExplain = showExplain;
    }

    /**
     * 获取是否考试结束后显示解析,1表示解析后,0表示立马看解析
     *
     * @return after_show_explain - 是否考试结束后显示解析,1表示解析后,0表示立马看解析
     */
    public Integer getAfterShowExplain() {
        return afterShowExplain;
    }

    /**
     * 设置是否考试结束后显示解析,1表示解析后,0表示立马看解析
     *
     * @param afterShowExplain 是否考试结束后显示解析,1表示解析后,0表示立马看解析
     */
    public void setAfterShowExplain(Integer afterShowExplain) {
        this.afterShowExplain = afterShowExplain;
    }

    /**
     * 获取是否能看到结果(指分数),0表示不能,1表示能
     *
     * @return view_result - 是否能看到结果(指分数),0表示不能,1表示能
     */
    public Integer getViewResult() {
        return viewResult;
    }

    /**
     * 设置是否能看到结果(指分数),0表示不能,1表示能
     *
     * @param viewResult 是否能看到结果(指分数),0表示不能,1表示能
     */
    public void setViewResult(Integer viewResult) {
        this.viewResult = viewResult;
    }
}
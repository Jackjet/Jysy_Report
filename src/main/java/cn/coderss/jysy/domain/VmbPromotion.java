package cn.coderss.jysy.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_promotion")
public class VmbPromotion {
    @Id
    @Column(name = "activityId")
    private Integer activityid;

    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动对应的LogoUrl
     */
    private String logourl;

    /**
     * 活动跳转到的Url
     */
    private String url;

    /**
     * 活动是否已发布（已发布的活动不得再次修改）
     */
    private Integer published;

    /**
     * 活动有效期起始时间
     */
    private Date starttime;

    /**
     * 活动有效期结束时间
     */
    private Date endtime;

    /**
     * 活动类型（打折，减免，降价，反馈积分，配套材料，徽章，无）
     */
    private Integer activityresult;

    /**
     * 活动效果（限时，永久，无）
     */
    private Integer activityeffective;

    /**
     * 活动触发动作（无，转发，注册，购买课程，签到，邀请，信息完善，任务完成，评论获得的赞达到指定数量）
     */
    private Integer activitytrigger;

    /**
     * 折扣（小于等于100，100为100%）
     */
    private Float discount;

    /**
     * 活动减免的具体费用
     */
    private BigDecimal cutprice;

    /**
     * 降价目标（此数字即为对应课程价格）
     */
    private BigDecimal downprice;

    /**
     * 赠送的积分数量
     */
    private Integer points;

    /**
     * 达到活动目标需要的转发次数
     */
    private Integer sharecount;

    /**
     * @return activityId
     */
    public Integer getActivityid() {
        return activityid;
    }

    /**
     * @param activityid
     */
    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
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
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取活动对应的LogoUrl
     *
     * @return logourl - 活动对应的LogoUrl
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * 设置活动对应的LogoUrl
     *
     * @param logourl 活动对应的LogoUrl
     */
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    /**
     * 获取活动跳转到的Url
     *
     * @return url - 活动跳转到的Url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置活动跳转到的Url
     *
     * @param url 活动跳转到的Url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取活动是否已发布（已发布的活动不得再次修改）
     *
     * @return published - 活动是否已发布（已发布的活动不得再次修改）
     */
    public Integer getPublished() {
        return published;
    }

    /**
     * 设置活动是否已发布（已发布的活动不得再次修改）
     *
     * @param published 活动是否已发布（已发布的活动不得再次修改）
     */
    public void setPublished(Integer published) {
        this.published = published;
    }

    /**
     * 获取活动有效期起始时间
     *
     * @return starttime - 活动有效期起始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置活动有效期起始时间
     *
     * @param starttime 活动有效期起始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取活动有效期结束时间
     *
     * @return endtime - 活动有效期结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置活动有效期结束时间
     *
     * @param endtime 活动有效期结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取活动类型（打折，减免，降价，反馈积分，配套材料，徽章，无）
     *
     * @return activityresult - 活动类型（打折，减免，降价，反馈积分，配套材料，徽章，无）
     */
    public Integer getActivityresult() {
        return activityresult;
    }

    /**
     * 设置活动类型（打折，减免，降价，反馈积分，配套材料，徽章，无）
     *
     * @param activityresult 活动类型（打折，减免，降价，反馈积分，配套材料，徽章，无）
     */
    public void setActivityresult(Integer activityresult) {
        this.activityresult = activityresult;
    }

    /**
     * 获取活动效果（限时，永久，无）
     *
     * @return activityeffective - 活动效果（限时，永久，无）
     */
    public Integer getActivityeffective() {
        return activityeffective;
    }

    /**
     * 设置活动效果（限时，永久，无）
     *
     * @param activityeffective 活动效果（限时，永久，无）
     */
    public void setActivityeffective(Integer activityeffective) {
        this.activityeffective = activityeffective;
    }

    /**
     * 获取活动触发动作（无，转发，注册，购买课程，签到，邀请，信息完善，任务完成，评论获得的赞达到指定数量）
     *
     * @return activitytrigger - 活动触发动作（无，转发，注册，购买课程，签到，邀请，信息完善，任务完成，评论获得的赞达到指定数量）
     */
    public Integer getActivitytrigger() {
        return activitytrigger;
    }

    /**
     * 设置活动触发动作（无，转发，注册，购买课程，签到，邀请，信息完善，任务完成，评论获得的赞达到指定数量）
     *
     * @param activitytrigger 活动触发动作（无，转发，注册，购买课程，签到，邀请，信息完善，任务完成，评论获得的赞达到指定数量）
     */
    public void setActivitytrigger(Integer activitytrigger) {
        this.activitytrigger = activitytrigger;
    }

    /**
     * 获取折扣（小于等于100，100为100%）
     *
     * @return discount - 折扣（小于等于100，100为100%）
     */
    public Float getDiscount() {
        return discount;
    }

    /**
     * 设置折扣（小于等于100，100为100%）
     *
     * @param discount 折扣（小于等于100，100为100%）
     */
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    /**
     * 获取活动减免的具体费用
     *
     * @return cutprice - 活动减免的具体费用
     */
    public BigDecimal getCutprice() {
        return cutprice;
    }

    /**
     * 设置活动减免的具体费用
     *
     * @param cutprice 活动减免的具体费用
     */
    public void setCutprice(BigDecimal cutprice) {
        this.cutprice = cutprice;
    }

    /**
     * 获取降价目标（此数字即为对应课程价格）
     *
     * @return downprice - 降价目标（此数字即为对应课程价格）
     */
    public BigDecimal getDownprice() {
        return downprice;
    }

    /**
     * 设置降价目标（此数字即为对应课程价格）
     *
     * @param downprice 降价目标（此数字即为对应课程价格）
     */
    public void setDownprice(BigDecimal downprice) {
        this.downprice = downprice;
    }

    /**
     * 获取赠送的积分数量
     *
     * @return points - 赠送的积分数量
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置赠送的积分数量
     *
     * @param points 赠送的积分数量
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取达到活动目标需要的转发次数
     *
     * @return sharecount - 达到活动目标需要的转发次数
     */
    public Integer getSharecount() {
        return sharecount;
    }

    /**
     * 设置达到活动目标需要的转发次数
     *
     * @param sharecount 达到活动目标需要的转发次数
     */
    public void setSharecount(Integer sharecount) {
        this.sharecount = sharecount;
    }
}
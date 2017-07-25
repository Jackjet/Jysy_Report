package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_relprofiledetail")
public class VmbRelprofiledetail {
    /**
     * 配置定制表id
     */
    @Id
    private Integer relprofiledetailid;

    /**
     * 点击跳转的类型（外部链接，视频类课程，调研，考试，学习计划，文档）
     */
    private Integer reltype;

    /**
     * 图片url
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 点击链接跳转的url
     */
    private String url;

    /**
     * 位置
     */
    private Integer position;

    /**
     * 关联的配置id
     */
    private Integer profiledetailid;

    /**
     * 跳转对象id
     */
    private Integer relobjectid;

    /**
     * 配置排序
     */
    private Integer orderindex;

    private String text;

    /**
     * 广告颜色
     */
    private String color;

    /**
     * 获取配置定制表id
     *
     * @return relprofiledetailid - 配置定制表id
     */
    public Integer getRelprofiledetailid() {
        return relprofiledetailid;
    }

    /**
     * 设置配置定制表id
     *
     * @param relprofiledetailid 配置定制表id
     */
    public void setRelprofiledetailid(Integer relprofiledetailid) {
        this.relprofiledetailid = relprofiledetailid;
    }

    /**
     * 获取点击跳转的类型（外部链接，视频类课程，调研，考试，学习计划，文档）
     *
     * @return reltype - 点击跳转的类型（外部链接，视频类课程，调研，考试，学习计划，文档）
     */
    public Integer getReltype() {
        return reltype;
    }

    /**
     * 设置点击跳转的类型（外部链接，视频类课程，调研，考试，学习计划，文档）
     *
     * @param reltype 点击跳转的类型（外部链接，视频类课程，调研，考试，学习计划，文档）
     */
    public void setReltype(Integer reltype) {
        this.reltype = reltype;
    }

    /**
     * 获取图片url
     *
     * @return image_url - 图片url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置图片url
     *
     * @param imageUrl 图片url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取点击链接跳转的url
     *
     * @return url - 点击链接跳转的url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置点击链接跳转的url
     *
     * @param url 点击链接跳转的url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取位置
     *
     * @return position - 位置
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 设置位置
     *
     * @param position 位置
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 获取关联的配置id
     *
     * @return profiledetailid - 关联的配置id
     */
    public Integer getProfiledetailid() {
        return profiledetailid;
    }

    /**
     * 设置关联的配置id
     *
     * @param profiledetailid 关联的配置id
     */
    public void setProfiledetailid(Integer profiledetailid) {
        this.profiledetailid = profiledetailid;
    }

    /**
     * 获取跳转对象id
     *
     * @return relobjectid - 跳转对象id
     */
    public Integer getRelobjectid() {
        return relobjectid;
    }

    /**
     * 设置跳转对象id
     *
     * @param relobjectid 跳转对象id
     */
    public void setRelobjectid(Integer relobjectid) {
        this.relobjectid = relobjectid;
    }

    /**
     * 获取配置排序
     *
     * @return orderindex - 配置排序
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * 设置配置排序
     *
     * @param orderindex 配置排序
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取广告颜色
     *
     * @return color - 广告颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置广告颜色
     *
     * @param color 广告颜色
     */
    public void setColor(String color) {
        this.color = color;
    }
}
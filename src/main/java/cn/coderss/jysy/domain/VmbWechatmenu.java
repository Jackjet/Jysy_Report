package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_wechatmenu")
public class VmbWechatmenu {
    @Id
    @Column(name = "wechatmenuId")
    private Integer wechatmenuid;

    private String name;

    /**
     * 菜单类型（URL，考试，调研，学习活动，学习活动分类，推广活动，培训班，首页）
     */
    private Integer type;

    /**
     * 需要关联的对象Id
     */
    @Column(name = "objectId")
    private Integer objectid;

    private String url;

    /**
     * 菜单对应的公众号
     */
    @Column(name = "wechatmpId")
    private Integer wechatmpid;

    /**
     * 上级菜单Id
     */
    @Column(name = "parentmenuId")
    private Integer parentmenuid;

    private Integer orderindex;

    private Integer heightindex;

    /**
     * @return wechatmenuId
     */
    public Integer getWechatmenuid() {
        return wechatmenuid;
    }

    /**
     * @param wechatmenuid
     */
    public void setWechatmenuid(Integer wechatmenuid) {
        this.wechatmenuid = wechatmenuid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单类型（URL，考试，调研，学习活动，学习活动分类，推广活动，培训班，首页）
     *
     * @return type - 菜单类型（URL，考试，调研，学习活动，学习活动分类，推广活动，培训班，首页）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置菜单类型（URL，考试，调研，学习活动，学习活动分类，推广活动，培训班，首页）
     *
     * @param type 菜单类型（URL，考试，调研，学习活动，学习活动分类，推广活动，培训班，首页）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取需要关联的对象Id
     *
     * @return objectId - 需要关联的对象Id
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * 设置需要关联的对象Id
     *
     * @param objectid 需要关联的对象Id
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取菜单对应的公众号
     *
     * @return wechatmpId - 菜单对应的公众号
     */
    public Integer getWechatmpid() {
        return wechatmpid;
    }

    /**
     * 设置菜单对应的公众号
     *
     * @param wechatmpid 菜单对应的公众号
     */
    public void setWechatmpid(Integer wechatmpid) {
        this.wechatmpid = wechatmpid;
    }

    /**
     * 获取上级菜单Id
     *
     * @return parentmenuId - 上级菜单Id
     */
    public Integer getParentmenuid() {
        return parentmenuid;
    }

    /**
     * 设置上级菜单Id
     *
     * @param parentmenuid 上级菜单Id
     */
    public void setParentmenuid(Integer parentmenuid) {
        this.parentmenuid = parentmenuid;
    }

    /**
     * @return orderindex
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * @param orderindex
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * @return heightindex
     */
    public Integer getHeightindex() {
        return heightindex;
    }

    /**
     * @param heightindex
     */
    public void setHeightindex(Integer heightindex) {
        this.heightindex = heightindex;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_microcoursetag")
public class VmbMicrocoursetag {
    @Id
    private Integer microcoursetagid;

    /**
     * tag 名称
     */
    private String tagname;

    /**
     * 排序
     */
    @Column(name = "orderIndex")
    private Integer orderindex;

    /**
     * @return microcoursetagid
     */
    public Integer getMicrocoursetagid() {
        return microcoursetagid;
    }

    /**
     * @param microcoursetagid
     */
    public void setMicrocoursetagid(Integer microcoursetagid) {
        this.microcoursetagid = microcoursetagid;
    }

    /**
     * 获取tag 名称
     *
     * @return tagname - tag 名称
     */
    public String getTagname() {
        return tagname;
    }

    /**
     * 设置tag 名称
     *
     * @param tagname tag 名称
     */
    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    /**
     * 获取排序
     *
     * @return orderIndex - 排序
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * 设置排序
     *
     * @param orderindex 排序
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }
}
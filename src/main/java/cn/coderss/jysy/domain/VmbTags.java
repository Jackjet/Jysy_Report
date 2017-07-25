package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_tags")
public class VmbTags {
    @Id
    @Column(name = "tagId")
    private Integer tagid;

    /**
     * 标签
     */
    private String tag;

    /**
     * @return tagId
     */
    public Integer getTagid() {
        return tagid;
    }

    /**
     * @param tagid
     */
    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    /**
     * 获取标签
     *
     * @return tag - 标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置标签
     *
     * @param tag 标签
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
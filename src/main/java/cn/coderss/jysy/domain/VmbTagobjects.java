package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_tagobjects")
public class VmbTagobjects {
    @Id
    @Column(name = "tagobjectsId")
    private Integer tagobjectsid;

    /**
     * 标签对应记录Id
     */
    @Column(name = "objectId")
    private Integer objectid;

    /**
     * 标签Id
     */
    @Column(name = "tagId")
    private Integer tagid;

    /**
     * 记录所在表
     */
    private String objecttablename;

    /**
     * @return tagobjectsId
     */
    public Integer getTagobjectsid() {
        return tagobjectsid;
    }

    /**
     * @param tagobjectsid
     */
    public void setTagobjectsid(Integer tagobjectsid) {
        this.tagobjectsid = tagobjectsid;
    }

    /**
     * 获取标签对应记录Id
     *
     * @return objectId - 标签对应记录Id
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * 设置标签对应记录Id
     *
     * @param objectid 标签对应记录Id
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * 获取标签Id
     *
     * @return tagId - 标签Id
     */
    public Integer getTagid() {
        return tagid;
    }

    /**
     * 设置标签Id
     *
     * @param tagid 标签Id
     */
    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    /**
     * 获取记录所在表
     *
     * @return objecttablename - 记录所在表
     */
    public String getObjecttablename() {
        return objecttablename;
    }

    /**
     * 设置记录所在表
     *
     * @param objecttablename 记录所在表
     */
    public void setObjecttablename(String objecttablename) {
        this.objecttablename = objecttablename;
    }
}
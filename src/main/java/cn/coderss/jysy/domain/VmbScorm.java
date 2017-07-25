package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_scorm")
public class VmbScorm {
    /**
     * scorm课件的ID
     */
    @Id
    private Integer scormid;

    /**
     * scorm课件的文件夹名称
     */
    private String scormname;

    @Column(name = "organization_title")
    private String organizationTitle;

    @Column(name = "organization_identifier")
    private String organizationIdentifier;

    @Column(name = "organization_structure")
    private String organizationStructure;

    @Column(name = "organization_item_title")
    private String organizationItemTitle;

    @Column(name = "organization_item_identifier")
    private String organizationItemIdentifier;

    @Column(name = "organization_item_identifierref")
    private String organizationItemIdentifierref;

    private String files;

    private Integer learningactivityid;

    private Integer valid;

    private Date createtime;

    private Integer width;

    private Integer height;

    /**
     * 获取scorm课件的ID
     *
     * @return scormid - scorm课件的ID
     */
    public Integer getScormid() {
        return scormid;
    }

    /**
     * 设置scorm课件的ID
     *
     * @param scormid scorm课件的ID
     */
    public void setScormid(Integer scormid) {
        this.scormid = scormid;
    }

    /**
     * 获取scorm课件的文件夹名称
     *
     * @return scormname - scorm课件的文件夹名称
     */
    public String getScormname() {
        return scormname;
    }

    /**
     * 设置scorm课件的文件夹名称
     *
     * @param scormname scorm课件的文件夹名称
     */
    public void setScormname(String scormname) {
        this.scormname = scormname;
    }

    /**
     * @return organization_title
     */
    public String getOrganizationTitle() {
        return organizationTitle;
    }

    /**
     * @param organizationTitle
     */
    public void setOrganizationTitle(String organizationTitle) {
        this.organizationTitle = organizationTitle;
    }

    /**
     * @return organization_identifier
     */
    public String getOrganizationIdentifier() {
        return organizationIdentifier;
    }

    /**
     * @param organizationIdentifier
     */
    public void setOrganizationIdentifier(String organizationIdentifier) {
        this.organizationIdentifier = organizationIdentifier;
    }

    /**
     * @return organization_structure
     */
    public String getOrganizationStructure() {
        return organizationStructure;
    }

    /**
     * @param organizationStructure
     */
    public void setOrganizationStructure(String organizationStructure) {
        this.organizationStructure = organizationStructure;
    }

    /**
     * @return organization_item_title
     */
    public String getOrganizationItemTitle() {
        return organizationItemTitle;
    }

    /**
     * @param organizationItemTitle
     */
    public void setOrganizationItemTitle(String organizationItemTitle) {
        this.organizationItemTitle = organizationItemTitle;
    }

    /**
     * @return organization_item_identifier
     */
    public String getOrganizationItemIdentifier() {
        return organizationItemIdentifier;
    }

    /**
     * @param organizationItemIdentifier
     */
    public void setOrganizationItemIdentifier(String organizationItemIdentifier) {
        this.organizationItemIdentifier = organizationItemIdentifier;
    }

    /**
     * @return organization_item_identifierref
     */
    public String getOrganizationItemIdentifierref() {
        return organizationItemIdentifierref;
    }

    /**
     * @param organizationItemIdentifierref
     */
    public void setOrganizationItemIdentifierref(String organizationItemIdentifierref) {
        this.organizationItemIdentifierref = organizationItemIdentifierref;
    }

    /**
     * @return files
     */
    public String getFiles() {
        return files;
    }

    /**
     * @param files
     */
    public void setFiles(String files) {
        this.files = files;
    }

    /**
     * @return learningactivityid
     */
    public Integer getLearningactivityid() {
        return learningactivityid;
    }

    /**
     * @param learningactivityid
     */
    public void setLearningactivityid(Integer learningactivityid) {
        this.learningactivityid = learningactivityid;
    }

    /**
     * @return valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }
}
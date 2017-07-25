package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_fileinfo")
public class VmbFileinfo {
    @Id
    private Integer fileinfoid;

    private Integer objectid;

    private Integer filetype;

    private Long filesize;

    private String filepath;

    private Integer collegeid;

    private Integer enterpriseid;

    private Date createtime;

    /**
     * @return fileinfoid
     */
    public Integer getFileinfoid() {
        return fileinfoid;
    }

    /**
     * @param fileinfoid
     */
    public void setFileinfoid(Integer fileinfoid) {
        this.fileinfoid = fileinfoid;
    }

    /**
     * @return objectid
     */
    public Integer getObjectid() {
        return objectid;
    }

    /**
     * @param objectid
     */
    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    /**
     * @return filetype
     */
    public Integer getFiletype() {
        return filetype;
    }

    /**
     * @param filetype
     */
    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }

    /**
     * @return filesize
     */
    public Long getFilesize() {
        return filesize;
    }

    /**
     * @param filesize
     */
    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    /**
     * @return filepath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @param filepath
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
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
}
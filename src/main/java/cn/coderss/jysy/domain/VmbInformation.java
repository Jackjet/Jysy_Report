package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_information")
public class VmbInformation {
    @Id
    @Column(name = "informationId")
    private Integer informationid;

    /**
     * 资料标题
     */
    private String title;

    /**
     * 资料类型（富文本，视频，文件上传，课程，考试，调研）
     */
    private Integer infotype;

    /**
     * 视频Url
     */
    private String videourl;

    /**
     * 关联记录Id（如果类型为考试则关联考试Id，如果类型为调研则为调研Id）
     */
    @Column(name = "recordId")
    private Integer recordid;

    /**
     * 详细内容（富文本）
     */
    private String description;

    /**
     * 可下载的文件Url
     */
    private String fileurl;

    /**
     * 需要跳转到的Url
     */
    private String redirecturl;

    @Column(name = "trainingProgramId")
    private Integer trainingprogramid;

    /**
     * 对应的资料包
     */
    @Column(name = "infoPackId")
    private Integer infopackid;

    /**
     * @return informationId
     */
    public Integer getInformationid() {
        return informationid;
    }

    /**
     * @param informationid
     */
    public void setInformationid(Integer informationid) {
        this.informationid = informationid;
    }

    /**
     * 获取资料标题
     *
     * @return title - 资料标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置资料标题
     *
     * @param title 资料标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取资料类型（富文本，视频，文件上传，课程，考试，调研）
     *
     * @return infotype - 资料类型（富文本，视频，文件上传，课程，考试，调研）
     */
    public Integer getInfotype() {
        return infotype;
    }

    /**
     * 设置资料类型（富文本，视频，文件上传，课程，考试，调研）
     *
     * @param infotype 资料类型（富文本，视频，文件上传，课程，考试，调研）
     */
    public void setInfotype(Integer infotype) {
        this.infotype = infotype;
    }

    /**
     * 获取视频Url
     *
     * @return videourl - 视频Url
     */
    public String getVideourl() {
        return videourl;
    }

    /**
     * 设置视频Url
     *
     * @param videourl 视频Url
     */
    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    /**
     * 获取关联记录Id（如果类型为考试则关联考试Id，如果类型为调研则为调研Id）
     *
     * @return recordId - 关联记录Id（如果类型为考试则关联考试Id，如果类型为调研则为调研Id）
     */
    public Integer getRecordid() {
        return recordid;
    }

    /**
     * 设置关联记录Id（如果类型为考试则关联考试Id，如果类型为调研则为调研Id）
     *
     * @param recordid 关联记录Id（如果类型为考试则关联考试Id，如果类型为调研则为调研Id）
     */
    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    /**
     * 获取详细内容（富文本）
     *
     * @return description - 详细内容（富文本）
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置详细内容（富文本）
     *
     * @param description 详细内容（富文本）
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取可下载的文件Url
     *
     * @return fileurl - 可下载的文件Url
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * 设置可下载的文件Url
     *
     * @param fileurl 可下载的文件Url
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    /**
     * 获取需要跳转到的Url
     *
     * @return redirecturl - 需要跳转到的Url
     */
    public String getRedirecturl() {
        return redirecturl;
    }

    /**
     * 设置需要跳转到的Url
     *
     * @param redirecturl 需要跳转到的Url
     */
    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    /**
     * @return trainingProgramId
     */
    public Integer getTrainingprogramid() {
        return trainingprogramid;
    }

    /**
     * @param trainingprogramid
     */
    public void setTrainingprogramid(Integer trainingprogramid) {
        this.trainingprogramid = trainingprogramid;
    }

    /**
     * 获取对应的资料包
     *
     * @return infoPackId - 对应的资料包
     */
    public Integer getInfopackid() {
        return infopackid;
    }

    /**
     * 设置对应的资料包
     *
     * @param infopackid 对应的资料包
     */
    public void setInfopackid(Integer infopackid) {
        this.infopackid = infopackid;
    }
}
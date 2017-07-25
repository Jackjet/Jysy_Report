package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_previewpdf")
public class VmbPreviewpdf {
    /**
     * 预览ID
     */
    @Id
    private Integer id;

    /**
     * pdf名称
     */
    private String pdfname;

    /**
     * 图片名称
     */
    private String imagename;

    /**
     * 获取预览ID
     *
     * @return id - 预览ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置预览ID
     *
     * @param id 预览ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取pdf名称
     *
     * @return pdfname - pdf名称
     */
    public String getPdfname() {
        return pdfname;
    }

    /**
     * 设置pdf名称
     *
     * @param pdfname pdf名称
     */
    public void setPdfname(String pdfname) {
        this.pdfname = pdfname;
    }

    /**
     * 获取图片名称
     *
     * @return imagename - 图片名称
     */
    public String getImagename() {
        return imagename;
    }

    /**
     * 设置图片名称
     *
     * @param imagename 图片名称
     */
    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_activitycatalog")
public class VmbActivitycatalog {
    @Id
    @Column(name = "catalogId")
    private Integer catalogid;

    /**
     * 所属企业Id
     */
    @Column(name = "collegeId")
    private Integer collegeid;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父级分类Id
     */
    @Column(name = "parentcatalogId")
    private Integer parentcatalogid;

    /**
     * 分类Logo Url
     */
    private String logourl;

    private Integer originalid;

    private Integer orderindex;

    private String code;

    /**
     * 区分资讯的分类还是其他分类
     */
    private Integer acttype;

    /**
     * @return catalogId
     */
    public Integer getCatalogid() {
        return catalogid;
    }

    /**
     * @param catalogid
     */
    public void setCatalogid(Integer catalogid) {
        this.catalogid = catalogid;
    }

    /**
     * 获取所属企业Id
     *
     * @return collegeId - 所属企业Id
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * 设置所属企业Id
     *
     * @param collegeid 所属企业Id
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父级分类Id
     *
     * @return parentcatalogId - 父级分类Id
     */
    public Integer getParentcatalogid() {
        return parentcatalogid;
    }

    /**
     * 设置父级分类Id
     *
     * @param parentcatalogid 父级分类Id
     */
    public void setParentcatalogid(Integer parentcatalogid) {
        this.parentcatalogid = parentcatalogid;
    }

    /**
     * 获取分类Logo Url
     *
     * @return logourl - 分类Logo Url
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * 设置分类Logo Url
     *
     * @param logourl 分类Logo Url
     */
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    /**
     * @return originalid
     */
    public Integer getOriginalid() {
        return originalid;
    }

    /**
     * @param originalid
     */
    public void setOriginalid(Integer originalid) {
        this.originalid = originalid;
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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取区分资讯的分类还是其他分类
     *
     * @return acttype - 区分资讯的分类还是其他分类
     */
    public Integer getActtype() {
        return acttype;
    }

    /**
     * 设置区分资讯的分类还是其他分类
     *
     * @param acttype 区分资讯的分类还是其他分类
     */
    public void setActtype(Integer acttype) {
        this.acttype = acttype;
    }
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_promotionactivitycatalog")
public class VmbPromotionactivitycatalog {
    @Id
    private Integer coursecatalogactivityid;

    @Column(name = "activityId")
    private Integer activityid;

    @Column(name = "catalogId")
    private Integer catalogid;

    /**
     * @return coursecatalogactivityid
     */
    public Integer getCoursecatalogactivityid() {
        return coursecatalogactivityid;
    }

    /**
     * @param coursecatalogactivityid
     */
    public void setCoursecatalogactivityid(Integer coursecatalogactivityid) {
        this.coursecatalogactivityid = coursecatalogactivityid;
    }

    /**
     * @return activityId
     */
    public Integer getActivityid() {
        return activityid;
    }

    /**
     * @param activityid
     */
    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

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
}
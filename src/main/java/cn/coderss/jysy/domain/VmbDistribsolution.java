package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vmb_distribsolution")
public class VmbDistribsolution {
    @Id
    @Column(name = "solutionId")
    private Integer solutionid;

    /**
     * 分配方案名称
     */
    private String name;

    /**
     * 分配时间
     */
    @Column(name = "distribTime")
    private Date distribtime;

    /**
     * 执行分配的操作员
     */
    @Column(name = "memberId")
    private Integer memberid;

    /**
     * 分配目标对象（学院，学员）
     */
    @Column(name = "destObject")
    private Integer destobject;

    /**
     * 发起分发的企业
     */
    @Column(name = "sourceEnterpriseId")
    private Integer sourceenterpriseid;

    /**
     * 发起分发的学院
     */
    @Column(name = "sourceCollegeId")
    private Integer sourcecollegeid;

    /**
     * 是否必修
     */
    private Boolean required;

    /**
     * 是否生效
     */
    private Boolean valid;

    @Column(name = "destCollegeId")
    private Integer destcollegeid;

    @Column(name = "destCount")
    private Integer destcount;

    private Boolean limit;

    private Integer public;

    private Integer recommend;

    private Integer infinite;

    private String destcode;

    private Integer destvalid;

    /**
     * @return solutionId
     */
    public Integer getSolutionid() {
        return solutionid;
    }

    /**
     * @param solutionid
     */
    public void setSolutionid(Integer solutionid) {
        this.solutionid = solutionid;
    }

    /**
     * 获取分配方案名称
     *
     * @return name - 分配方案名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分配方案名称
     *
     * @param name 分配方案名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取分配时间
     *
     * @return distribTime - 分配时间
     */
    public Date getDistribtime() {
        return distribtime;
    }

    /**
     * 设置分配时间
     *
     * @param distribtime 分配时间
     */
    public void setDistribtime(Date distribtime) {
        this.distribtime = distribtime;
    }

    /**
     * 获取执行分配的操作员
     *
     * @return memberId - 执行分配的操作员
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * 设置执行分配的操作员
     *
     * @param memberid 执行分配的操作员
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * 获取分配目标对象（学院，学员）
     *
     * @return destObject - 分配目标对象（学院，学员）
     */
    public Integer getDestobject() {
        return destobject;
    }

    /**
     * 设置分配目标对象（学院，学员）
     *
     * @param destobject 分配目标对象（学院，学员）
     */
    public void setDestobject(Integer destobject) {
        this.destobject = destobject;
    }

    /**
     * 获取发起分发的企业
     *
     * @return sourceEnterpriseId - 发起分发的企业
     */
    public Integer getSourceenterpriseid() {
        return sourceenterpriseid;
    }

    /**
     * 设置发起分发的企业
     *
     * @param sourceenterpriseid 发起分发的企业
     */
    public void setSourceenterpriseid(Integer sourceenterpriseid) {
        this.sourceenterpriseid = sourceenterpriseid;
    }

    /**
     * 获取发起分发的学院
     *
     * @return sourceCollegeId - 发起分发的学院
     */
    public Integer getSourcecollegeid() {
        return sourcecollegeid;
    }

    /**
     * 设置发起分发的学院
     *
     * @param sourcecollegeid 发起分发的学院
     */
    public void setSourcecollegeid(Integer sourcecollegeid) {
        this.sourcecollegeid = sourcecollegeid;
    }

    /**
     * 获取是否必修
     *
     * @return required - 是否必修
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * 设置是否必修
     *
     * @param required 是否必修
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * 获取是否生效
     *
     * @return valid - 是否生效
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 设置是否生效
     *
     * @param valid 是否生效
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * @return destCollegeId
     */
    public Integer getDestcollegeid() {
        return destcollegeid;
    }

    /**
     * @param destcollegeid
     */
    public void setDestcollegeid(Integer destcollegeid) {
        this.destcollegeid = destcollegeid;
    }

    /**
     * @return destCount
     */
    public Integer getDestcount() {
        return destcount;
    }

    /**
     * @param destcount
     */
    public void setDestcount(Integer destcount) {
        this.destcount = destcount;
    }

    /**
     * @return limit
     */
    public Boolean getLimit() {
        return limit;
    }

    /**
     * @param limit
     */
    public void setLimit(Boolean limit) {
        this.limit = limit;
    }

    /**
     * @return public
     */
    public Integer getPublic() {
        return public;
    }

    /**
     * @param public
     */
    public void setPublic(Integer public) {
        this.public = public;
    }

    /**
     * @return recommend
     */
    public Integer getRecommend() {
        return recommend;
    }

    /**
     * @param recommend
     */
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    /**
     * @return infinite
     */
    public Integer getInfinite() {
        return infinite;
    }

    /**
     * @param infinite
     */
    public void setInfinite(Integer infinite) {
        this.infinite = infinite;
    }

    /**
     * @return destcode
     */
    public String getDestcode() {
        return destcode;
    }

    /**
     * @param destcode
     */
    public void setDestcode(String destcode) {
        this.destcode = destcode;
    }

    /**
     * @return destvalid
     */
    public Integer getDestvalid() {
        return destvalid;
    }

    /**
     * @param destvalid
     */
    public void setDestvalid(Integer destvalid) {
        this.destvalid = destvalid;
    }
}
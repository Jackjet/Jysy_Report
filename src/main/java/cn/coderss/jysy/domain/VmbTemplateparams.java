package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_templateparams")
public class VmbTemplateparams {
    @Id
    private Integer templateparamid;

    private Integer templateid;

    private String name;

    /**
     * @return templateparamid
     */
    public Integer getTemplateparamid() {
        return templateparamid;
    }

    /**
     * @param templateparamid
     */
    public void setTemplateparamid(Integer templateparamid) {
        this.templateparamid = templateparamid;
    }

    /**
     * @return templateid
     */
    public Integer getTemplateid() {
        return templateid;
    }

    /**
     * @param templateid
     */
    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
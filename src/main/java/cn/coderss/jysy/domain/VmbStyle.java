package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_style")
public class VmbStyle {
    @Id
    @Column(name = "styleId")
    private Integer styleid;

    private String name;

    private String color;

    private String code;

    /**
     * @return styleId
     */
    public Integer getStyleid() {
        return styleid;
    }

    /**
     * @param styleid
     */
    public void setStyleid(Integer styleid) {
        this.styleid = styleid;
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

    /**
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
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
}
package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "django_content_type")
public class DjangoContentType {
    @Id
    private Integer id;

    private String name;

    @Column(name = "app_label")
    private String appLabel;

    private String model;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return app_label
     */
    public String getAppLabel() {
        return appLabel;
    }

    /**
     * @param appLabel
     */
    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    /**
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }
}
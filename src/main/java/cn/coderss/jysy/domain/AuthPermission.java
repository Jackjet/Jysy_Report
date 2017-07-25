package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "auth_permission")
public class AuthPermission {
    @Id
    private Integer id;

    private String name;

    @Column(name = "content_type_id")
    private Integer contentTypeId;

    private String codename;

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
     * @return content_type_id
     */
    public Integer getContentTypeId() {
        return contentTypeId;
    }

    /**
     * @param contentTypeId
     */
    public void setContentTypeId(Integer contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    /**
     * @return codename
     */
    public String getCodename() {
        return codename;
    }

    /**
     * @param codename
     */
    public void setCodename(String codename) {
        this.codename = codename;
    }
}
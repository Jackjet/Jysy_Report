package cn.coderss.jysy.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "django_migrations")
public class DjangoMigrations {
    @Id
    private Integer id;

    private String app;

    private String name;

    private Date applied;

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
     * @return app
     */
    public String getApp() {
        return app;
    }

    /**
     * @param app
     */
    public void setApp(String app) {
        this.app = app;
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
     * @return applied
     */
    public Date getApplied() {
        return applied;
    }

    /**
     * @param applied
     */
    public void setApplied(Date applied) {
        this.applied = applied;
    }
}
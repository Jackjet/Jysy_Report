package cn.coderss.jysy.domain;

import javax.persistence.*;

public class Test02 {
    @Id
    private Integer id;

    private String accountname;

    private String name;

    private String departname;

    private String code;

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
     * @return accountname
     */
    public String getAccountname() {
        return accountname;
    }

    /**
     * @param accountname
     */
    public void setAccountname(String accountname) {
        this.accountname = accountname;
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
     * @return departname
     */
    public String getDepartname() {
        return departname;
    }

    /**
     * @param departname
     */
    public void setDepartname(String departname) {
        this.departname = departname;
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
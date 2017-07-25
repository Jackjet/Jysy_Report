package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "tmp_ac")
public class TmpAc {
    private String name;

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
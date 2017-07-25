package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_person")
public class VmbPerson {
    /**
     * 账户名
     */
    private String name;

    /**
     * 获取账户名
     *
     * @return name - 账户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置账户名
     *
     * @param name 账户名
     */
    public void setName(String name) {
        this.name = name;
    }
}
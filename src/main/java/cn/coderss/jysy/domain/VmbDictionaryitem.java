package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_dictionaryitem")
public class VmbDictionaryitem {
    @Id
    @Column(name = "itemId")
    private Integer itemid;

    @Column(name = "dictionaryId")
    private Integer dictionaryid;

    /**
     * 显示内容
     */
    private String display;

    /**
     * 值
     */
    private String code;

    /**
     * @return itemId
     */
    public Integer getItemid() {
        return itemid;
    }

    /**
     * @param itemid
     */
    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    /**
     * @return dictionaryId
     */
    public Integer getDictionaryid() {
        return dictionaryid;
    }

    /**
     * @param dictionaryid
     */
    public void setDictionaryid(Integer dictionaryid) {
        this.dictionaryid = dictionaryid;
    }

    /**
     * 获取显示内容
     *
     * @return display - 显示内容
     */
    public String getDisplay() {
        return display;
    }

    /**
     * 设置显示内容
     *
     * @param display 显示内容
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * 获取值
     *
     * @return code - 值
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置值
     *
     * @param code 值
     */
    public void setCode(String code) {
        this.code = code;
    }
}
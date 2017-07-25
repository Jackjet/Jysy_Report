package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_dictionary")
public class VmbDictionary {
    @Id
    @Column(name = "dictionaryId")
    private Integer dictionaryid;

    private String name;

    private String code;

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
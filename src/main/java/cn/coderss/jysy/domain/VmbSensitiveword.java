package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_sensitiveword")
public class VmbSensitiveword {
    @Id
    @Column(name = "wordId")
    private Integer wordid;

    private String keyword;

    /**
     * @return wordId
     */
    public Integer getWordid() {
        return wordid;
    }

    /**
     * @param wordid
     */
    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }

    /**
     * @return keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
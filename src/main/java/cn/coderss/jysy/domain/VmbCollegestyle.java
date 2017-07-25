package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_collegestyle")
public class VmbCollegestyle {
    @Id
    @Column(name = "collegeStyleId")
    private Integer collegestyleid;

    /**
     * @return collegeStyleId
     */
    public Integer getCollegestyleid() {
        return collegestyleid;
    }

    /**
     * @param collegestyleid
     */
    public void setCollegestyleid(Integer collegestyleid) {
        this.collegestyleid = collegestyleid;
    }
}
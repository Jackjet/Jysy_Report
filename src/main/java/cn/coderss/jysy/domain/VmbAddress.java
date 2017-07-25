package cn.coderss.jysy.domain;

import javax.persistence.*;

@Table(name = "vmb_address")
public class VmbAddress {
    @Id
    private Integer addressid;

    @Column(name = "detail_address")
    private String detailAddress;

    private Integer accountid;

    /**
     * 邮政编码
     */
    private String zipcode;

    /**
     * @return addressid
     */
    public Integer getAddressid() {
        return addressid;
    }

    /**
     * @param addressid
     */
    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    /**
     * @return detail_address
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * @param detailAddress
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    /**
     * @return accountid
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * 获取邮政编码
     *
     * @return zipcode - 邮政编码
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 设置邮政编码
     *
     * @param zipcode 邮政编码
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
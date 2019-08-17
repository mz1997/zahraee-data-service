package com.mz.data.loadView;


import java.util.Date;

public class AddressLoad {

    private Integer id;
    private String address;
    private String address2;
    private String district;
    private Integer cityId;
    private Integer countryId;
    private Integer pCode;
    private Long phone;
    private Date lUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getpCode() {
        return pCode;
    }

    public void setpCode(Integer pCode) {
        this.pCode = pCode;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}

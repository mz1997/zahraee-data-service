package com.mz.data.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "address")
public class Address extends BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id" , nullable = false)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "postal_code")
    private Integer pCode;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "last_update" , nullable = false)
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
}

package com.mz.data.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "city")
public class City extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id" , nullable = false)
    private Integer id;

    @Column(name = "city" , nullable = false)
    private String name;

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

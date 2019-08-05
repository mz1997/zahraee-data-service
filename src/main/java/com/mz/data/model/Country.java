package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "country")
public class Country extends BaseEntity<Integer> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id" , nullable = false)
    private Integer id;

    @Column(name = "country" , nullable = false)
    private String name;

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

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

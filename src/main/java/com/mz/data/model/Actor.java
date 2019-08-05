package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor")
public class Actor extends BaseEntity <Integer> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id" , nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

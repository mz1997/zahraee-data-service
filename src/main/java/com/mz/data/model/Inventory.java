package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id" , nullable = false)
    private Integer id;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

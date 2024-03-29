package com.mz.data.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "store")
public class Store extends BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id" , nullable = false)
    private Integer id;

    @Column(name = "manager_staff_id", nullable = false)
    private Integer manager_staff_id;

    @OneToOne(targetEntity = Address.class)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(Integer manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

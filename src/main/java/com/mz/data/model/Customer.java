package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id" , nullable = false)
    private Integer id;

    @ManyToOne(targetEntity = Store.class)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "first_name" , nullable = false)
    private String fName;

    @Column(name = "last_name" , nullable = false)
    private String lName;

    @Column(name = "email")
    private String email;

    @OneToOne(targetEntity = Address.class)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "active" ,nullable = false)
    private Integer active;

    @Column(name = "create_date" , nullable = false)
    private Date cDate;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

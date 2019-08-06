package com.mz.data.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rental")
public class Rental extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rental_id" , nullable = false)
    private Integer id;

    @Column(name = "rental_date" , nullable = false)
    private Date rentalDate;

    @ManyToOne(targetEntity = Inventory.class)
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "return_date" , nullable = false)
    private Date returnDate;

    @ManyToOne(targetEntity = Staff.class)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

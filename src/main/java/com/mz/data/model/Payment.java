package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id" , nullable = false)
    private Integer id;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne(targetEntity = Staff.class)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne(targetEntity = Rental.class)
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @Column(name = "amount" )
    private Double amount;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

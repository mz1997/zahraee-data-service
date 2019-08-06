package com.mz.data.postView;

import com.mz.data.model.Customer;
import com.mz.data.model.Rental;
import com.mz.data.model.Staff;

import java.util.Date;

public class PaymentPost {


    private Customer customer;
    private Staff staff;
    private Rental rental;
    private Double amount;
    private Date paymentDate;

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
}

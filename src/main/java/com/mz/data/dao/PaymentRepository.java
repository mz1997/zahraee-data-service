package com.mz.data.dao;

import com.mz.data.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {


    @Query("select id,customer.id,amount from Payment where customer.id = :id")
    Object[] payByCustomer (@Param("id") Integer id );
}

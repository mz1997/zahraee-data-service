package com.mz.data.dao;

import com.mz.data.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Integer> {

    @Query("select rentalDate,inventory.id,customer.id,staff.id,returnDate from Rental where customer.id = :customerId")
    Object[] rentalByCustomerId (@Param("customerId") Integer customerId);
}

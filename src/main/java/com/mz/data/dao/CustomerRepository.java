package com.mz.data.dao;

import com.mz.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {

    @Query("select fName as first_name,lName from Customer where address.id in (select id from Address where city.id in(select id from City where country.id =:countryId ))")
    List<Customer> listCustomer (@Param("countryId") Integer countryId);
}

package com.mz.data.dao;

import com.mz.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address , Integer> {

    @Query("select address,city.id,city.country.id,city.country.name,pCode,phone  from Address where city.id in(select id from City where country.id = :countryId) ")
    Object[] listAddress (@Param("countryId") Integer countryId);

}

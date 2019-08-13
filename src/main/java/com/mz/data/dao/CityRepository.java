package com.mz.data.dao;


import com.mz.data.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

  //  @Query("select count(id) from City  where City.country.id = :countryId")
    //Integer getCountByCountryId (@Param("countryId")Integer countryId);
}

package com.mz.data.dao;

import com.mz.data.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository <Actor , Integer> {


    @Query("select fName,lName from Actor")
    List<Actor> listActors ();

}

package com.mz.data.dao;

import com.mz.data.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film , Integer> {

    @Query(value ="select film_id,title,CAST(release_year AS SIGNED ),language_id from film where film_id in (select film_id from film_category where category_id = :categoryId)" , nativeQuery =true)
    Object[] filmCategory (@Param("categoryId") Integer categoryId);

    @Query(value = "select film_id,title,CAST(release_year AS SIGNED ),language_id from film where film_id in (select film_id from film_actor where actor_id in(select actor_id from actor where last_name like %:actorLastName%));",nativeQuery = true)
    Object[] filmByActorName(@Param("actorLastName") String actorLastName);

    @Query("select f.id,f.title,f.lYear,f.language.id,f.length,c.id,c.name from Film f join f.categories c where c.id = :categoryId")
    Object[] searchFilmByCategoryIdHql (@Param("categoryId") Integer categoryId);

    @Query("select f.id,f.title,f.lYear,f.language.id,f.length,a.id,a.fName,a.lName from Film f join f.actors a where a.lName like %:actorLastName%")
    Object[] searchFilmByActorLastNameHql (@Param("actorLastName")String actorLastName );
}


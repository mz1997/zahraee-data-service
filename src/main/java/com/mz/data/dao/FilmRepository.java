package com.mz.data.dao;

import com.mz.data.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film , Integer> {

    @Query(value = "SELECT film_id,CAST(release_year AS SIGNED ),language_id,category_id,Category.name  FROM Film LEFT JOIN Category ON Category.Category_id = :categoryId " , nativeQuery =true)
    Object[] filmCategory (@Param("categoryId") Integer categoryId);
}

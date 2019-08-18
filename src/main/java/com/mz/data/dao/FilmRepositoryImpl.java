package com.mz.data.dao;

import com.mz.data.model.Film;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class FilmRepositoryImpl implements IFilmRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Film> getFilms() {
        Query query = entityManager.createQuery("");
        return query.getResultList();
    }
}

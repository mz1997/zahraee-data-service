package com.mz.data.service.impl;

import com.mz.data.dao.FilmRepository;
import com.mz.data.model.Film;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService extends GenericService<Film , Integer> implements IFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    protected JpaRepository<Film, Integer> jpaRepository() {
        return filmRepository;
    }
}

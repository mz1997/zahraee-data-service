package com.mz.data.dao;


import com.mz.data.model.Film;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilmRepository {

    List<Film> getFilms();

}

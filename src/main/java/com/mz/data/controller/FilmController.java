package com.mz.data.controller;

import com.mz.data.model.Film;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.IFilmService;
import com.mz.data.view.FilmView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Film film) {
        filmService.save(film);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Film load(@PathVariable Integer id) {
        return filmService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        filmService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Film film) {
        filmService.edit(film);
    }

    @RequestMapping(value = "/getAllFilm", method = RequestMethod.GET)
    public List<Film> getAll() {
        return filmService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Film> save(@RequestBody FilmView filmView){
        Film film = new Film();
        film.setTitle(filmView.getTitle());
        film.setDescription(filmView.getDescription());
        film.setlYear(filmView.getlYear());
        film.setLanguage(filmView.getLanguage());
        film.setOriginalLanguage(filmView.getOriginalLanguage());
        film.setrDuration(filmView.getrDuration());
        film.setrRate(filmView.getrRate());
        film.setLength(filmView.getLength());
        film.setrCost(filmView.getrCost());
        film.setRating(filmView.getRating());
        film.setsFeatures(filmView.getsFeatures());
        film.setlUpdate(filmView.getlUpdate());
        return filmService.findAll(filmView.getPage(),filmView.getSize() , film);
    }
}

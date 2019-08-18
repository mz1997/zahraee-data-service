package com.mz.data.controller;



import com.mz.data.dao.view.DaoFilmView;
import com.mz.data.loadView.ActorLoad;
import com.mz.data.loadView.FilmLoad;
import com.mz.data.model.Actor;
import com.mz.data.model.Film;
import com.mz.data.model.Pagination;
import com.mz.data.postView.ActorPost;
import com.mz.data.postView.FilmPost;
import com.mz.data.service.interfaces.IFilmService;
import com.mz.data.view.ActorView;
import com.mz.data.view.FilmView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody FilmPost filmPost) {
        Film film = mapper.map(filmPost ,Film.class);
        if (filmPost.getId()!= null){
            throw new RuntimeException();
        }
        filmService.save(film);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody FilmPost filmPost) {
        Film film = mapper.map(filmPost ,Film.class);
        if (filmPost.getId()== null){
            throw new RuntimeException();
        }
        filmService.edit(film);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public FilmLoad load(@PathVariable Integer id) {
        return convert(filmService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        filmService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllFilm", method = RequestMethod.GET)
    public List<FilmLoad> getAll() {
        List<Film> listFilms = new ArrayList<Film>();
        listFilms = filmService.getAll();
        List<FilmLoad> list =  new ArrayList<FilmLoad>();
        for(Film filmFor : listFilms)
        {
            list.add(convert(filmFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<FilmLoad> search(@RequestBody(required = false) FilmView filmView){
        Film film =  mapper.map(filmView ,Film.class);
        Page<Film> temps = filmService.findAll(filmView.getPage(), filmView.getSize() , film);
        List<Film> listFilms = temps.getContent();
        List<FilmLoad> list =  new ArrayList<FilmLoad>();
        for(Film filmFor : listFilms)
        {
            list.add(convert(filmFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private FilmLoad convert(Film film)
    {
        FilmLoad retuenValue =   mapper.map(film ,FilmLoad.class);
        return retuenValue;
    }

    @RequestMapping(value = "/searchFilmByCategoryId/{id}" , method = RequestMethod.GET)
    public List<DaoFilmView> filmCategory (@PathVariable Integer id){
        return filmService.filmCategory(id);
    }


}

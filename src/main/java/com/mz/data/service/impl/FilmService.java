package com.mz.data.service.impl;

import com.mz.data.dao.FilmRepository;
import com.mz.data.dao.view.DaoFilmView;
import com.mz.data.dao.view.DaoFilmViewHql;
import com.mz.data.model.Film;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FilmService extends GenericService<Film , Integer> implements IFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    protected JpaRepository<Film, Integer> jpaRepository() {
        return filmRepository;
    }

    @Override
    public void save(Film entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Film entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public List<DaoFilmView> filmCategory(Integer categoryId) {
        List<DaoFilmView> retValue = new ArrayList<DaoFilmView>();
        Object[] temp = filmRepository.filmCategory(categoryId);
        for (Object ojb : temp){

            Object[] tem = (Object[]) ojb;
            DaoFilmView daoFilmView = new DaoFilmView();
            daoFilmView.setId(tem[0].hashCode());
            daoFilmView.setTitle(tem[1].toString());
            daoFilmView.setlYear(tem[2].hashCode());
            daoFilmView.setLanguageId(tem[3].hashCode());
            retValue.add(daoFilmView);
        }

        return retValue;
    }

    @Override
    public List<DaoFilmView> filmByActorName(String actorLastName) {
        List<DaoFilmView> retValue = new ArrayList<DaoFilmView>();
        Object[] temp = filmRepository.filmByActorName(actorLastName);
        for (Object ojb : temp){

            Object[] tem = (Object[]) ojb;
            DaoFilmView daoFilmView = new DaoFilmView();
            daoFilmView.setId(tem[0].hashCode());
            daoFilmView.setTitle(tem[1].toString());
            daoFilmView.setlYear(tem[2].hashCode());
            daoFilmView.setLanguageId(tem[3].hashCode());
            retValue.add(daoFilmView);
        }

        return retValue;
    }

    @Override
    public List<DaoFilmViewHql> searchFilmByCategoryIdHql(Integer categoryId) {
        List<DaoFilmViewHql> retValue = new ArrayList<DaoFilmViewHql>();
        Object[] temp = filmRepository.searchFilmByCategoryIdHql(categoryId);
        for (Object ojb : temp) {

            Object[] tem = (Object[]) ojb;
            DaoFilmViewHql daoFilmViewHql = new DaoFilmViewHql();
            daoFilmViewHql.setId(tem[0].hashCode());
            daoFilmViewHql.setTitle(tem[1].toString());
            daoFilmViewHql.setlYear(tem[2].hashCode());
            daoFilmViewHql.setLanguageId(tem[3].hashCode());
            daoFilmViewHql.setLength(tem[4].hashCode());
            daoFilmViewHql.setCategoryId(tem[5].hashCode());
            daoFilmViewHql.setCategoryName(tem[6].toString());
            retValue.add(daoFilmViewHql);
        }

        return retValue;
    }
}

package com.mz.data.service.impl;

import com.mz.data.dao.FilmRepository;
import com.mz.data.dao.view.DaoFilmView;
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
            daoFilmView.setlYear(tem[1].hashCode());
            daoFilmView.setLanguageId(tem[2].hashCode());
            daoFilmView.setCategoryId(tem[3].hashCode());
            daoFilmView.setCategoryName(tem[4].toString());
            retValue.add(daoFilmView);
        }

        return retValue;
    }
}

package com.mz.data.service.interfaces;

import com.mz.data.dao.view.DaoFilmView;
import com.mz.data.dao.view.DaoFilmViewHql;
import com.mz.data.model.Film;

import java.util.List;

public interface IFilmService extends IGenericService <Film , Integer> {

    List<DaoFilmView> filmCategory (Integer categoryId);
    List<DaoFilmView> filmByActorName (String actorLastName);
    List<DaoFilmViewHql> searchFilmByCategoryIdHql (Integer categoryId);

}

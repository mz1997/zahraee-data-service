package com.mz.data.service.impl;

import com.mz.data.dao.LanguageRepository;
import com.mz.data.model.Film;
import com.mz.data.model.Language;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LanguageService extends GenericService<Language,Integer> implements ILanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    protected JpaRepository<Language, Integer> jpaRepository() {
        return languageRepository;
    }

    @Override
    public void save(Language entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Language entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }


}

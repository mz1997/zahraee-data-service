package com.mz.data.service.impl;

import com.mz.data.dao.CityRepository;
import com.mz.data.model.City;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CityService extends GenericService<City , Integer> implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    protected JpaRepository<City, Integer> jpaRepository() {
        return cityRepository;
    }

    @Override
    public void save(City entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(City entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }
}

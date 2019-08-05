package com.mz.data.service.impl;

import com.mz.data.dao.CountryRepository;
import com.mz.data.model.Country;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends GenericService<Country , Integer> implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    protected JpaRepository<Country, Integer> jpaRepository() {
        return countryRepository;
    }
}

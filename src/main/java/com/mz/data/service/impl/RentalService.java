package com.mz.data.service.impl;


import com.mz.data.dao.RentalRepository;
import com.mz.data.model.Rental;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RentalService extends GenericService<Rental,Integer> implements IRentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    protected JpaRepository<Rental, Integer> jpaRepository() {
        return rentalRepository;
    }

    @Override
    public void save(Rental entity) {
        entity.setlUpdate(new Date());
        entity.setRentalDate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Rental entity) {
        entity.setReturnDate(new Date());
        entity.setlUpdate(new Date());
        super.save(entity);
    }
}

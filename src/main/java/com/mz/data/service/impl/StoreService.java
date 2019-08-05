package com.mz.data.service.impl;


import com.mz.data.dao.StoreRepository;
import com.mz.data.model.Store;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StoreService extends GenericService<Store , Integer>  implements IStoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    protected JpaRepository<Store, Integer> jpaRepository() {
        return storeRepository;
    }

    @Override
    public void save(Store entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Store entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }
}

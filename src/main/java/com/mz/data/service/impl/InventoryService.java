package com.mz.data.service.impl;


import com.mz.data.dao.InventoryRepository;
import com.mz.data.model.Inventory;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InventoryService extends GenericService<Inventory , Integer> implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    protected JpaRepository<Inventory, Integer> jpaRepository() {
        return inventoryRepository;
    }

    @Override
    public void save(Inventory entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Inventory entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }
}

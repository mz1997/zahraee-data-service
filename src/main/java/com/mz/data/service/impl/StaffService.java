package com.mz.data.service.impl;


import com.mz.data.dao.StaffRepository;
import com.mz.data.model.Staff;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StaffService extends GenericService<Staff,Integer> implements IStaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    protected JpaRepository<Staff, Integer> jpaRepository() {
        return staffRepository;
    }

    @Override
    public void save(Staff entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Staff entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }
}

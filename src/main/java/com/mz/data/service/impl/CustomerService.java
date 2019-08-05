package com.mz.data.service.impl;

import com.mz.data.dao.CustomerRepository;
import com.mz.data.model.Customer;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService extends GenericService<Customer , Integer> implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    protected JpaRepository<Customer, Integer> jpaRepository() {
        return customerRepository;
    }

    @Override
    public void save(Customer entity) {
        entity.setcDate(new Date());
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Customer entity) {
        entity.setlUpdate(new Date());
        super.edit(entity);
    }
}

package com.mz.data.service.impl;


import com.mz.data.dao.AddressRepository;
import com.mz.data.model.Address;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressService extends GenericService<Address , Integer> implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    protected JpaRepository<Address, Integer> jpaRepository() {
        return addressRepository;
    }

    @Override
    public void save(Address entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Address entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public List<Address> listAddress(Integer countryId) {
        return addressRepository.listAddress(countryId);
    }
}

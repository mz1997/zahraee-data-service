package com.mz.data.service.impl;


import com.mz.data.dao.AddressRepository;
import com.mz.data.model.Address;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends GenericService<Address , Integer> implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    protected JpaRepository<Address, Integer> jpaRepository() {
        return null;
    }
}

package com.mz.data.service.impl;


import com.mz.data.dao.AddressRepository;
import com.mz.data.dao.view.DaoAddressView;
import com.mz.data.model.Address;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<DaoAddressView> listAddress(Integer countryId) {
        List<DaoAddressView> retValue = new ArrayList<DaoAddressView>();
        Object[] temp = addressRepository.listAddress(countryId);
        for (Object obj : temp){

            Object[] tem = (Object[])obj;
            DaoAddressView d = new DaoAddressView();
            d.setAddress(tem[0].toString());
            d.setCityId(tem[1].hashCode());
            d.setCountryId(tem[2].hashCode());
            d.setCountryName(tem[3].toString());
            d.setpCode(tem[4].hashCode());
            d.setPhone((long) tem[5].hashCode());
            retValue.add(d);
        }

        return retValue;
    }
}

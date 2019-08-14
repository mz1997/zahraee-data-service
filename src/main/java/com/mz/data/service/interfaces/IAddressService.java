package com.mz.data.service.interfaces;

import com.mz.data.model.Address;

import java.util.List;

public interface IAddressService extends IGenericService<Address , Integer> {

    List<Address> listAddress (Integer countryId);
}

package com.mz.data.service.interfaces;

import com.mz.data.dao.view.DaoCustomerView;
import com.mz.data.model.Customer;

import java.util.List;


public interface ICustomerService extends IGenericService<Customer , Integer> {

    List<DaoCustomerView> listCustomer (Integer countryId);
}

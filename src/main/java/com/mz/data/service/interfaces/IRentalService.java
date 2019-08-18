package com.mz.data.service.interfaces;

import com.mz.data.dao.view.DaoRentalView;
import com.mz.data.model.Rental;

import java.util.List;

public interface IRentalService extends IGenericService<Rental,Integer> {

    List<DaoRentalView> rentalByCustomerId (Integer customerId);
}

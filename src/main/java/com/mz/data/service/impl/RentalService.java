package com.mz.data.service.impl;


import com.mz.data.dao.RentalRepository;
import com.mz.data.dao.view.DaoRentalView;
import com.mz.data.model.Rental;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RentalService extends GenericService<Rental,Integer> implements IRentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    protected JpaRepository<Rental, Integer> jpaRepository() {
        return rentalRepository;
    }

    @Override
    public void save(Rental entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Rental entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public List<DaoRentalView> rentalByCustomerId(Integer customerId) {
        List<DaoRentalView> retValue = new ArrayList<DaoRentalView>();
        Object[] temp = rentalRepository.rentalByCustomerId(customerId);
        for (Object ojb : temp){

            Object[] tem = (Object[]) ojb;
            DaoRentalView daoRentalView = new DaoRentalView();
            daoRentalView.setRentalDate((Date) tem[0]);
            daoRentalView.setInventoryId(tem[1].hashCode());
            daoRentalView.setCustomerId(tem[2].hashCode());
            daoRentalView.setStaffId(tem[3].hashCode());
            daoRentalView.setReturnDate((Date) tem[4]);
            retValue.add(daoRentalView);
        }


        return retValue;
    }
}

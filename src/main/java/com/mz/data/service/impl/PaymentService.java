package com.mz.data.service.impl;

import com.mz.data.dao.PaymentRepository;
import com.mz.data.dao.view.DaoPaymentView;
import com.mz.data.model.Payment;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService extends GenericService<Payment,Integer> implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    protected JpaRepository<Payment, Integer> jpaRepository() {
        return paymentRepository;
    }

    @Override
    public void save(Payment entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Payment entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public List<DaoPaymentView> paymentByCustomerId(Integer id) {
        List<DaoPaymentView> retValues = new ArrayList<DaoPaymentView>();
        Object[] temp = paymentRepository.payByCustomer(id);
        for (Object ojb : temp){
            Object[] tem = (Object[]) ojb;
            DaoPaymentView daoPaymentView = new DaoPaymentView();
            daoPaymentView.setId(tem[0].hashCode());
            daoPaymentView.setCustomerId(tem[1].hashCode());
            daoPaymentView.setAmount((double) tem[2].hashCode());
            retValues.add(daoPaymentView);
        }

        return retValues;

    }
}

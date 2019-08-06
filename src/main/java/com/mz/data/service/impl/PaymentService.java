package com.mz.data.service.impl;

import com.mz.data.dao.PaymentRepository;
import com.mz.data.model.Payment;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}

package com.mz.data.service.interfaces;

import com.mz.data.dao.view.DaoPaymentView;
import com.mz.data.model.Payment;

import java.util.List;

public interface IPaymentService extends IGenericService<Payment,Integer> {


    List<DaoPaymentView> paymentByCustomerId (Integer id);
}

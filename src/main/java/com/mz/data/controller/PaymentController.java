package com.mz.data.controller;


import com.mz.data.loadView.PaymentLoad;
import com.mz.data.model.Pagination;
import com.mz.data.model.Payment;
import com.mz.data.postView.PaymentPost;
import com.mz.data.service.interfaces.IPaymentService;
import com.mz.data.view.PaymentView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody PaymentPost paymentPost) {
        Payment payment = mapper.map(paymentPost ,Payment.class);
        if (paymentPost.getId()!= null){
            throw new RuntimeException();
        }
        paymentService.save(payment);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody PaymentPost paymentPost) {
        Payment payment = mapper.map(paymentPost ,Payment.class);
        if (paymentPost.getId()== null){
            throw new RuntimeException();
        }
        paymentService.edit(payment);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public PaymentLoad load(@PathVariable Integer id) {
        return convert(paymentService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        paymentService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllPayment", method = RequestMethod.GET)
    public List<PaymentLoad> getAll() {
        List<Payment> listPayments = new ArrayList<Payment>();
        listPayments = paymentService.getAll();
        List<PaymentLoad> list =  new ArrayList<PaymentLoad>();
        for(Payment paymentFor : listPayments)
        {
            list.add(convert(paymentFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Payment> search (@RequestBody PaymentView paymentView){
        Payment payment =  mapper.map(paymentView ,Payment.class);
        Page<Payment> temps = paymentService.findAll(paymentView.getPage(), paymentView.getSize() , payment);
        List<Payment> listPayments = temps.getContent();
        List<PaymentLoad> list =  new ArrayList<PaymentLoad>();
        for(Payment paymentFor : listPayments)
        {
            list.add(convert(paymentFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private PaymentLoad convert(Payment payment)
    {
        PaymentLoad retuenValue =   mapper.map(payment ,PaymentLoad.class);
        return retuenValue;
    }

}

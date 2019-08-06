package com.mz.data.controller;


import com.mz.data.model.Pagination;
import com.mz.data.model.Payment;
import com.mz.data.service.interfaces.IPaymentService;
import com.mz.data.view.PaymentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Payment payment) {
        paymentService.save(payment);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Payment load(@PathVariable Integer id) {
        return paymentService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        paymentService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Payment payment) {
        paymentService.edit(payment);
    }

    @RequestMapping(value = "/getAllPayment", method = RequestMethod.GET)
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Payment> save(@RequestBody PaymentView paymentView){
        Payment payment = new Payment();
        payment.setCustomer(paymentView.getCustomer());
        payment.setStaff(paymentView.getStaff());
        payment.setRental(paymentView.getRental());
        payment.setAmount(paymentView.getAmount());
        payment.setPaymentDate(paymentView.getPaymentDate());
        return paymentService.findAll(paymentView.getPage(),paymentView.getSize(),payment);
    }

}

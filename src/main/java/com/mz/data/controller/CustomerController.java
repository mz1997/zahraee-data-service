package com.mz.data.controller;


import com.mz.data.model.Customer;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.ICustomerService;
import com.mz.data.view.CustomerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Customer load(@PathVariable Integer id) {
        return customerService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Customer customer) {
        customerService.edit(customer);
    }

    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET)
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Customer> save(@RequestBody CustomerView customerView){
        Customer customer = new Customer();
        customer.setStore(customerView.getStore());
        customer.setfName(customerView.getfName());
        customer.setlName(customerView.getlName());
        customer.setEmail(customerView.getEmail());
        customer.setAddress(customerView.getAddress());
        customer.setActive(customerView.getActive());
        return  customerService.findAll(customerView.getPage(),customerView.getSize(),customer);

    }

}

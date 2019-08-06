package com.mz.data.controller;


import com.mz.data.loadView.CustomerLoad;
import com.mz.data.model.Actor;
import com.mz.data.model.Customer;
import com.mz.data.model.Pagination;
import com.mz.data.postView.CustomerPost;
import com.mz.data.service.interfaces.ICustomerService;
import com.mz.data.view.CustomerView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody CustomerPost customerPost) {
        Customer customer = mapper.map(customerPost ,Customer.class);
        if (customerPost.getId()!= null){
            throw new RuntimeException();
        }
        customerService.save(customer);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody CustomerPost customerPost) {
        Customer customer = mapper.map(customerPost ,Customer.class);
        if (customerPost.getId()== null){
            throw new RuntimeException();
        }
        customerService.edit(customer);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public CustomerLoad load(@PathVariable Integer id) {
        return convert(customerService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET)
    public List<CustomerLoad> getAll() {
        List<Customer> listCustomer = new ArrayList<Customer>();
        listCustomer = customerService.getAll();
        List<CustomerLoad> list =  new ArrayList<CustomerLoad>();
        for(Customer customerFor : listCustomer)
        {
            list.add(convert(customerFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Actor> search(@RequestBody CustomerView customerView){
        Customer customer =  mapper.map(customerView ,Customer.class);
        Page<Customer> temps = customerService.findAll(customerView.getPage(), customerView.getSize() , customer);
        List<Customer> listCustomers = temps.getContent();
        List<CustomerLoad> list =  new ArrayList<CustomerLoad>();
        for(Customer customerFor : listCustomers)
        {
            list.add(convert(customerFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private CustomerLoad convert(Customer customer)
    {
        CustomerLoad retuenValue =   mapper.map(customer ,CustomerLoad.class);
        return retuenValue;
    }

}

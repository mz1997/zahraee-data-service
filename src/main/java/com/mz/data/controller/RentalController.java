package com.mz.data.controller;


import com.mz.data.model.Pagination;
import com.mz.data.model.Rental;
import com.mz.data.service.interfaces.IRentalService;
import com.mz.data.view.RentalView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    IRentalService rentalService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Rental rental) {
        rentalService.save(rental);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Rental load(@PathVariable Integer id) {
        return rentalService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        rentalService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Rental rental) {
        rentalService.edit(rental);
    }

    @RequestMapping(value = "/getAllRental", method = RequestMethod.GET)
    public List<Rental> getAll() {
        return rentalService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Rental> save(@RequestBody RentalView rentalView){
        Rental rental = new Rental();
        rental.setInventory(rentalView.getInventory());
        rental.setCustomer(rentalView.getCustomer());
        rental.setStaff(rentalView.getStaff());
        return rentalService.findAll(rentalView.getPage(),rentalView.getSize(),rental);
    }
}

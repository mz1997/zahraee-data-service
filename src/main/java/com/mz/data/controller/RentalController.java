package com.mz.data.controller;


import com.mz.data.dao.view.DaoRentalView;
import com.mz.data.loadView.RentalLoad;
import com.mz.data.model.Pagination;
import com.mz.data.model.Rental;
import com.mz.data.postView.RentalPost;
import com.mz.data.service.interfaces.IRentalService;
import com.mz.data.view.RentalView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    IRentalService rentalService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody RentalPost rentalPost) {
        Rental rental = mapper.map(rentalPost ,Rental.class);
        if (rentalPost.getId()!= null){
            throw new RuntimeException();
        }
        rentalService.save(rental);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody RentalPost rentalPost) {
        Rental rental = mapper.map(rentalPost ,Rental.class);
        if (rentalPost.getId()== null){
            throw new RuntimeException();
        }
        rentalService.edit(rental);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public RentalLoad load(@PathVariable Integer id) {
        return convert(rentalService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        rentalService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllRental", method = RequestMethod.GET)
    public List<RentalLoad> getAll() {
        List<Rental> listRentals = new ArrayList<Rental>();
        listRentals = rentalService.getAll();
        List<RentalLoad> list =  new ArrayList<RentalLoad>();
        for(Rental rentalFor : listRentals)
        {
            list.add(convert(rentalFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<RentalLoad> search (@RequestBody(required = false) RentalView rentalView){
        Rental rental =  mapper.map(rentalView ,Rental.class);
        Page<Rental> temps = rentalService.findAll(rentalView.getPage(), rentalView.getSize() , rental);
        List<Rental> listRentals = temps.getContent();
        List<RentalLoad> list =  new ArrayList<RentalLoad>();
        for(Rental rentalFor : listRentals)
        {
            list.add(convert(rentalFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private RentalLoad convert(Rental rental)
    {
        RentalLoad retuenValue =   mapper.map(rental ,RentalLoad.class);
        return retuenValue;
    }

    @RequestMapping(value = "/rentalByCustomerId/{id}" , method = RequestMethod.GET)
    public List<DaoRentalView> rentalByCustomerId (@PathVariable Integer id){
        return rentalService.rentalByCustomerId(id);
    }

}

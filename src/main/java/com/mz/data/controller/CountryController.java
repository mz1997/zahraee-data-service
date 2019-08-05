package com.mz.data.controller;


import com.mz.data.model.Country;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.ICountryService;
import com.mz.data.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Country country) {
        countryService.save(country);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Country load(@PathVariable Integer id) {
        return countryService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        countryService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Country country) {
        countryService.edit(country);
    }

    @RequestMapping(value = "/getAllCountry", method = RequestMethod.GET)
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Country> save(@RequestBody CountryView countryView){
        Country country = new Country();
        country.setName(countryView.getName());
        country.setlUpdate(countryView.getlUpdate());
        return countryService.findAll(countryView.getPage(),countryView.getSize() , country);
    }

}

package com.mz.data.controller;


import com.mz.data.loadView.CountryLoad;
import com.mz.data.model.Country;
import com.mz.data.model.Pagination;
import com.mz.data.postView.CountryPost;
import com.mz.data.service.interfaces.ICountryService;
import com.mz.data.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody CountryPost countryPost) {
        Country country = new Country();
        country.setName(countryPost.getName());
        if (countryPost.getId()!= null){
            throw new RuntimeException();
        }
        countryService.save(country);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody CountryPost countryPost) {
        Country country = new Country();
        country.setId(countryPost.getId());
        country.setName(countryPost.getName());
        if (countryPost.getId()== null){
            throw new RuntimeException();
        }
        countryService.edit(country);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public CountryLoad load(@PathVariable Integer id) {
        return convert(countryService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        countryService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllCountry", method = RequestMethod.GET)
    public List<CountryLoad> getAll() {
        List<Country> listCountry = new ArrayList<Country>();
        listCountry = countryService.getAll();
        List<CountryLoad> list =  new ArrayList<CountryLoad>();
        for(Country countryFor : listCountry)
        {
            list.add(convert(countryFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Country> save(@RequestBody CountryView countryView){
        Country country = new Country();
        country.setName(countryView.getName());
        Page<Country> temps = countryService.findAll(countryView.getPage(), countryView.getSize() , country);
        List<Country> listCountry = temps.getContent();
        List<CountryLoad> list =  new ArrayList<CountryLoad>();
        for(Country countryFor : listCountry)
        {
            list.add(convert(countryFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private CountryLoad convert(Country country)
    {
        CountryLoad retuenValue =  new CountryLoad();
        retuenValue.setId(country.getId());
        retuenValue.setName(country.getName());
        retuenValue.setlUpdate(country.getlUpdate());
        return retuenValue;
    }

}

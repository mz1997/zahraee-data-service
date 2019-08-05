package com.mz.data.controller;


import com.mz.data.model.City;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.ICityService;
import com.mz.data.view.CityView;
import com.mz.data.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody City city) {
        cityService.save(city);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public City load(@PathVariable Integer id) {
        return cityService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody City city) {
        cityService.edit(city);
    }

    @RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
    public List<City> getAll() {
        return cityService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<City> save(@RequestBody CityView cityView){
        City city = new City();
        city.setName(cityView.getName());
        city.setCountry(cityView.getCountry());
        city.setlUpdate(cityView.getlUpdate());
        return cityService.findAll(cityView.getPage(),cityView.getSize(),city);
    }

}

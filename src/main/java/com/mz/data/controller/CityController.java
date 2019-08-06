package com.mz.data.controller;


import com.mz.data.loadView.CityLoad;
import com.mz.data.model.City;
import com.mz.data.model.Pagination;
import com.mz.data.postView.CityPost;
import com.mz.data.service.interfaces.ICityService;
import com.mz.data.view.CityView;
import com.mz.data.view.CountryView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody CityPost cityPost) {
        City city = mapper.map(cityPost ,City.class);
        if (cityPost.getId()!= null){
            throw new RuntimeException();
        }
        cityService.save(city);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody CityPost cityPost) {
        City city = mapper.map(cityPost ,City.class);
        if (cityPost.getId()== null){
            throw new RuntimeException();
        }
        cityService.edit(city);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public CityLoad load(@PathVariable Integer id) {
        return convert(cityService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
    public List<CityLoad> getAll() {
        List<City> listCity = new ArrayList<City>();
        listCity = cityService.getAll();
        List<CityLoad> list =  new ArrayList<CityLoad>();
        for(City cityFor : listCity)
        {
            list.add(convert(cityFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<City> search(@RequestBody CityView cityView){
        City city = mapper.map(cityView ,City.class);
        Page<City> temps = cityService.findAll(cityView.getPage(), cityView.getSize() , city);
        List<City> listCity = temps.getContent();
        List<CityLoad> list =  new ArrayList<CityLoad>();
        for(City cityFor : listCity)
        {
            list.add(convert(cityFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private CityLoad convert(City city)
    {
        CityLoad retuenValue =  mapper.map(city ,CityLoad.class);
        return retuenValue;
    }

}

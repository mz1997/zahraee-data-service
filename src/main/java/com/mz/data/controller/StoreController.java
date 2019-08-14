package com.mz.data.controller;


import com.mz.data.loadView.StoreLoad;
import com.mz.data.model.Pagination;
import com.mz.data.model.Store;
import com.mz.data.postView.StorePost;
import com.mz.data.service.interfaces.IStoreService;
import com.mz.data.view.StoreView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private IStoreService storeService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody StorePost storePost) {
        Store store = mapper.map(storePost ,Store.class);
        if (storePost.getId()!= null){
            throw new RuntimeException();
        }
        storeService.save(store);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody StorePost storePost) {
        Store store = mapper.map(storePost ,Store.class);
        if (storePost.getId()== null){
            throw new RuntimeException();
        }
        storeService.edit(store);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public StoreLoad load(@PathVariable Integer id) {
        return convert(storeService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        storeService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllStore", method = RequestMethod.GET)
    public List<StoreLoad> getAll() {
        List<Store> listStores = new ArrayList<Store>();
        listStores = storeService.getAll();
        List<StoreLoad> list =  new ArrayList<StoreLoad>();
        for(Store storeFor : listStores)
        {
            list.add(convert(storeFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<StoreLoad> search (@RequestBody(required = false) StoreView storeView){
        Store store =  mapper.map(storeView ,Store.class);
        Page<Store> temps = storeService.findAll(storeView.getPage(), storeView.getSize() , store);
        List<Store> listStores = temps.getContent();
        List<StoreLoad> list =  new ArrayList<StoreLoad>();
        for(Store storeFor : listStores)
        {
            list.add(convert(storeFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private StoreLoad convert(Store store)
    {
        StoreLoad retuenValue =   mapper.map(store ,StoreLoad.class);
        return retuenValue;
    }
}

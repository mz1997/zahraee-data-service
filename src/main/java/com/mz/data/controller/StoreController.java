package com.mz.data.controller;


import com.mz.data.model.Pagination;
import com.mz.data.model.Store;
import com.mz.data.service.interfaces.IStoreService;
import com.mz.data.view.StoreView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private IStoreService storeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Store store) {
        storeService.save(store);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Store load(@PathVariable Integer id) {
        return storeService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        storeService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Store store) {
        storeService.edit(store);
    }

    @RequestMapping(value = "/getAllStore", method = RequestMethod.GET)
    public List<Store> getAll() {
        return storeService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Store> save(@RequestBody StoreView storeView){
        Store store = new Store();
        store.setManager_staff_id(storeView.getManager_staff_id());
        store.setAddress(storeView.getAddress());
        store.setlUpdate(storeView.getlUpdate());
        return storeService.findAll(storeView.getPage(),storeView.getSize(),store);
    }
}

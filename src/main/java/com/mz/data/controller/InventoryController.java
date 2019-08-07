package com.mz.data.controller;



import com.mz.data.loadView.InventoryLoad;
import com.mz.data.model.Inventory;
import com.mz.data.model.Pagination;
import com.mz.data.postView.InventoryPost;
import com.mz.data.service.interfaces.IInventoryService;
import com.mz.data.view.InventoryView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    IInventoryService inventoryService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody InventoryPost inventoryPost) {
        Inventory inventory = mapper.map(inventoryPost ,Inventory.class);
        if (inventoryPost.getId()!= null){
            throw new RuntimeException();
        }
        inventoryService.save(inventory);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody InventoryPost inventoryPost) {
        Inventory inventory = mapper.map(inventoryPost ,Inventory.class);
        if (inventoryPost.getId()== null){
            throw new RuntimeException();
        }
        inventoryService.edit(inventory);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public InventoryLoad load(@PathVariable Integer id) {
        return convert(inventoryService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        inventoryService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllInventory", method = RequestMethod.GET)
    public List<InventoryLoad> getAll() {
        List<Inventory> listInventorys = new ArrayList<Inventory>();
        listInventorys = inventoryService.getAll();
        List<InventoryLoad> list =  new ArrayList<InventoryLoad>();
        for(Inventory inventoryFor : listInventorys)
        {
            list.add(convert(inventoryFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Inventory> search (@RequestBody InventoryView inventoryView){
        Inventory inventory =  mapper.map(inventoryView ,Inventory.class);
        Page<Inventory> temps = inventoryService.findAll(inventoryView.getPage(), inventoryView.getSize() , inventory);
        List<Inventory> listInventory = temps.getContent();
        List<InventoryLoad> list =  new ArrayList<InventoryLoad>();
        for(Inventory inventoryFor : listInventory)
        {
            list.add(convert(inventoryFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private InventoryLoad convert(Inventory inventory)
    {
        InventoryLoad retuenValue =   mapper.map(inventory ,InventoryLoad.class);
        return retuenValue;
    }
}

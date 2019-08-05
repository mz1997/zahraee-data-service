package com.mz.data.controller;


import com.mz.data.model.Inventory;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.IInventoryService;
import com.mz.data.view.InventoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    IInventoryService inventoryService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Inventory inventory) {
        inventoryService.save(inventory);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Inventory load(@PathVariable Integer id) {
        return inventoryService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        inventoryService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Inventory inventory) {
        inventoryService.edit(inventory);
    }

    @RequestMapping(value = "/getAllInventory", method = RequestMethod.GET)
    public List<Inventory> getAll() {
        return inventoryService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Inventory> save(@RequestBody InventoryView inventoryView){
        Inventory inventory = new Inventory();
        return inventoryService.findAll(inventoryView.getPage(),inventoryView.getSize(),inventory);
    }
}

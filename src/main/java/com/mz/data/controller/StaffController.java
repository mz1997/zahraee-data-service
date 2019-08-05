package com.mz.data.controller;


import com.mz.data.model.Pagination;
import com.mz.data.model.Staff;
import com.mz.data.service.interfaces.IStaffService;
import com.mz.data.view.StaffView;
import com.mz.data.view.StoreView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Staff staff) {
        staffService.save(staff);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Staff load(@PathVariable Integer id) {
        return staffService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        staffService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Staff staff) {
        staffService.edit(staff);
    }

    @RequestMapping(value = "/getAllStore", method = RequestMethod.GET)
    public List<Staff> getAll() {
        return staffService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Staff> save(@RequestBody StaffView staffView){
        Staff staff = new Staff();
        staff.setfName(staffView.getfName());
        staff.setlName(staffView.getlName());
        staff.setEmail(staffView.getEmail());
        staff.setAddress(staffView.getAddress());
        staff.setActive(staffView.getActive());
        staff.setStore(staffView.getStore());
        staff.setUserName(staffView.getUserName());
        staff.setPassword(staffView.getPassword());
        return staffService.findAll(staffView.getPage(),staffView.getSize(),staff);

    }

}

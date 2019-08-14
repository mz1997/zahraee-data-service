package com.mz.data.controller;


import com.mz.data.loadView.StaffLoad;
import com.mz.data.model.Pagination;
import com.mz.data.model.Staff;
import com.mz.data.postView.StaffPost;
import com.mz.data.service.interfaces.IStaffService;
import com.mz.data.view.StaffView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody StaffPost staffPost) {
        Staff staff = mapper.map(staffPost ,Staff.class);
        if (staffPost.getId()!= null){
            throw new RuntimeException();
        }
        staffService.save(staff);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody StaffPost staffPost) {
        Staff staff = mapper.map(staffPost ,Staff.class);
        if (staffPost.getId()== null){
            throw new RuntimeException();
        }
        staffService.edit(staff);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public StaffLoad load(@PathVariable Integer id) {
        return convert(staffService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        staffService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllStaff", method = RequestMethod.GET)
    public List<StaffLoad> getAll() {
        List<Staff> listStaffs = new ArrayList<Staff>();
        listStaffs = staffService.getAll();
        List<StaffLoad> list =  new ArrayList<StaffLoad>();
        for(Staff staffFor : listStaffs)
        {
            list.add(convert(staffFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<StaffLoad> search (@RequestBody(required = false) StaffView staffView){
        Staff staff =  mapper.map(staffView,Staff.class);
        Page<Staff> temps = staffService.findAll(staffView.getPage(), staffView.getSize() , staff);
        List<Staff> listStaffs = temps.getContent();
        List<StaffLoad> list =  new ArrayList<StaffLoad>();
        for(Staff staffFor : listStaffs)
        {
            list.add(convert(staffFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private StaffLoad convert(Staff staff)
    {
        StaffLoad retuenValue =   mapper.map(staff ,StaffLoad.class);
        return retuenValue;
    }

}

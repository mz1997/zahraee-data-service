package com.mz.data.controller;


import com.mz.data.loadView.AddressLoad;
import com.mz.data.model.Address;
import com.mz.data.model.Pagination;
import com.mz.data.postView.AddressPost;
import com.mz.data.service.interfaces.IAddressService;
import com.mz.data.view.AddressView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;


    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AddressPost addressPost) {
        Address address = new Address();
        address.setAddress(addressPost.getAddress());
        address.setAddress2(addressPost.getAddress2());
        address.setDistrict(addressPost.getDistrict());
        address.setCity(addressPost.getCity());
        address.setpCode(addressPost.getpCode());
        address.setPhone(addressPost.getPhone());
        if (addressPost.getId()!= null){
            throw new RuntimeException();
        }
        addressService.save(address);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody AddressPost addressPost) {
        Address address = new Address();
        address.setId(addressPost.getId());
        address.setAddress(addressPost.getAddress());
        address.setAddress2(addressPost.getAddress2());
        address.setDistrict(addressPost.getDistrict());
        address.setCity(addressPost.getCity());
        address.setpCode(addressPost.getpCode());
        address.setPhone(addressPost.getPhone());
        if (addressPost.getId()== null){
            throw new RuntimeException();
        }
        addressService.edit(address);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AddressLoad load(@PathVariable Integer id) {
        return convert(addressService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllAddress", method = RequestMethod.GET)
    public List<AddressLoad> getAll() {
        List<Address> listAddress = new ArrayList<Address>();
        listAddress = addressService.getAll();
        List<AddressLoad> list =  new ArrayList<AddressLoad>();
        for(Address addressFor : listAddress)
        {
            list.add(convert(addressFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Address> search(@RequestBody AddressView addressView){
        Address address = new Address();
        address.setId(addressView.getId());
        address.setAddress(addressView.getAddress());
        address.setAddress2(addressView.getAddress2());
        address.setDistrict(addressView.getDistrict());
        address.setCity(addressView.getCity());
        address.setpCode(addressView.getpCode());
        address.setPhone(addressView.getPhone());
        Page<Address> temps = addressService.findAll(addressView.getPage(), addressView.getSize() , address);
        List<Address> listAddress = temps.getContent();
        List<AddressLoad> list =  new ArrayList<AddressLoad>();
        for(Address addressFor : listAddress)
        {
            list.add(convert(addressFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private AddressLoad convert(Address address)
    {
        AddressLoad retuenValue =  new AddressLoad();
        retuenValue.setId(address.getId());
        retuenValue.setAddress(address.getAddress());
        retuenValue.setAddress2(address.getAddress2());
        retuenValue.setDistrict(address.getDistrict());
        retuenValue.setCity(address.getCity());
        retuenValue.setpCode(address.getpCode());
        retuenValue.setPhone(address.getPhone());
        retuenValue.setlUpdate(address.getlUpdate());
        return retuenValue;
    }
}

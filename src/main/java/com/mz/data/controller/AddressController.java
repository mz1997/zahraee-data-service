package com.mz.data.controller;


import com.mz.data.model.Address;
import com.mz.data.model.Pagination;
import com.mz.data.postView.AddressPost;
import com.mz.data.service.interfaces.IAddressService;
import com.mz.data.view.AddressView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

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

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Address load(@PathVariable Integer id) {
        return addressService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Address address) {
        addressService.edit(address);
    }

    @RequestMapping(value = "/getAllAddress", method = RequestMethod.GET)
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Address> save(@RequestBody AddressView addressView){
        Address address = new Address();
        address.setAddress(addressView.getAddress());
        address.setAddress2(addressView.getAddress2());
        address.setDistrict(addressView.getDistrict());
        address.setCity(addressView.getCity());
        address.setpCode(addressView.getpCode());
        address.setPhone(addressView.getPhone());
        return addressService.findAll(addressView.getPage(),addressView.getSize() , address);

    }
}

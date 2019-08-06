package com.mz.data.postView;

import com.mz.data.model.Address;

public class StorePost {


    private Integer id;
    private Integer manager_staff_id;
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(Integer manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

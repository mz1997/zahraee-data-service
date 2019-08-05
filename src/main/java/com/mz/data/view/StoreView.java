package com.mz.data.view;

import com.mz.data.model.Address;

import java.util.Date;

public class StoreView {

    private int page;
    private int size;
    private Integer id;
    private Integer manager_staff_id;
    private Address address;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

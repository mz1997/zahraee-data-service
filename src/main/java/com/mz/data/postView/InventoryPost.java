package com.mz.data.postView;

import com.mz.data.model.Film;
import com.mz.data.model.Store;

import java.util.List;

public class InventoryPost {


    private Integer id;
    private List<Film> films;
    private List<Store> stores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}

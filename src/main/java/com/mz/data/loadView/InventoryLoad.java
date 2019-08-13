package com.mz.data.loadView;

import com.mz.data.model.Film;
import com.mz.data.model.Store;

import java.util.Date;
import java.util.List;

public class InventoryLoad {

    private Integer id;
    private List<Film> films;
    private List<Store> stores;
    private Date lUpdate;

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

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

package com.mz.data.view;


import com.mz.data.loadView.FilmLoad;
import com.mz.data.loadView.StoreLoad;
import com.mz.data.model.Film;
import com.mz.data.model.Store;

import java.util.List;

public class InventoryView {

    private int page;
    private int size;
    private Integer id;
    private List<FilmView> films;
    private List<StoreView> stores;

    public List<FilmView> getFilms() {
        return films;
    }

    public void setFilms(List<FilmView> films) {
        this.films = films;
    }

    public List<StoreView> getStores() {
        return stores;
    }

    public void setStores(List<StoreView> stores) {
        this.stores = stores;
    }

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

}

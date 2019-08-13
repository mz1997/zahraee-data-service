package com.mz.data.postView;

import com.mz.data.model.Film;
import com.mz.data.model.Store;

import java.util.List;

public class InventoryPost {


    private Integer id;
    private List<FilmPost> films;
    private List<StorePost> stores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<FilmPost> getFilms() {
        return films;
    }

    public void setFilms(List<FilmPost> films) {
        this.films = films;
    }

    public List<StorePost> getStores() {
        return stores;
    }

    public void setStores(List<StorePost> stores) {
        this.stores = stores;
    }
}

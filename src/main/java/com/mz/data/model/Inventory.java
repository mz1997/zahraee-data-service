package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id" , nullable = false)
    private Integer id;

    @OneToMany(targetEntity = Film.class)
    @JoinColumn(name = "film_id")
    private List<Film> films;

    @OneToMany(targetEntity = Store.class)
    @JoinColumn(name = "store_id")
    private List<Store> stores;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

package com.mz.data.model;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id" , nullable = false)
    private Integer id;

    @ManyToOne(targetEntity = Film.class)
    @JoinColumn(name = "film_id" , nullable = false)
    private Film film;
}

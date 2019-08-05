package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "language")
public class Language extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "language_id" , nullable = false)
    private Integer id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;
}

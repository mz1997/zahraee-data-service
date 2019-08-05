package com.mz.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name= "film")
public class Film extends BaseEntity<Integer> {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "film_actor" , joinColumns = {@JoinColumn(name = "film_id")},inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private List<Actor> actors;

    @ManyToMany(targetEntity = Actor.class,cascade = {CascadeType.ALL})
    @JoinTable(name = "film_category" , joinColumns = {@JoinColumn(name = "film_id")},inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id" , nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year" ,nullable = false)
    private Integer lYear;

    @ManyToOne(targetEntity = Language.class)
    @JoinColumn(name ="language_id",nullable = false)
    private Language language;

    @ManyToOne(targetEntity = Language.class)
    @JoinColumn(name ="original_language_id")
    private Language OriginalLanguage;

    @Column(name = "rental_duration",nullable = false)
    private Integer rDuration;

    @Column(name = "rental_rate",nullable = false)
    private Double rRate;

    @Column(name = "length" ,nullable = false)
    private Integer length;

    @Column(name = "replacement_cost",nullable = false)
    private Double rCost;

    @Column(name = "rating",nullable = false)
    private String rating;

    @Column(name = "special_features",nullable = false)
    private String sFeatures;

    @Column(name = "last_update" , nullable = false)
    private Date lUpdate;


    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getlYear() {
        return lYear;
    }

    public void setlYear(Integer lYear) {
        this.lYear = lYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return OriginalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        OriginalLanguage = originalLanguage;
    }

    public Integer getrDuration() {
        return rDuration;
    }

    public void setrDuration(Integer rDuration) {
        this.rDuration = rDuration;
    }

    public Double getrRate() {
        return rRate;
    }

    public void setrRate(Double rRate) {
        this.rRate = rRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getrCost() {
        return rCost;
    }

    public void setrCost(Double rCost) {
        this.rCost = rCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getsFeatures() {
        return sFeatures;
    }

    public void setsFeatures(String sFeatures) {
        this.sFeatures = sFeatures;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

package com.mz.data.view;

import com.mz.data.model.Language;

import java.util.Date;

public class FilmView {

    private int page;
    private int size;
    private Integer id;
    private String title;
    private String description;
    private Integer lYear;
    private Language language;
    private Language OriginalLanguage;
    private Integer rDuration;
    private Double rRate;
    private Integer length;
    private Double rCost;
    private String rating;
    private String sFeatures;

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

}

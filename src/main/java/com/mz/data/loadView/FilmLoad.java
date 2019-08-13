package com.mz.data.loadView;

import com.mz.data.model.Language;

import java.util.Date;

public class FilmLoad {


    private Integer id;
    private String title;
    private String description;
    private Integer lYear;
    private Integer languageId;
    private Integer OriginalLanguageId;
    private Integer rDuration;
    private Double rRate;
    private Integer length;
    private Double rCost;
    private String rating;
    private String sFeatures;
    private Date lUpdate;

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

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getOriginalLanguageId() {
        return OriginalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        OriginalLanguageId = originalLanguageId;
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

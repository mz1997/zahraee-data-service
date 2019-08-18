package com.mz.data.dao.view;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DaoFilmView {

    @JsonProperty(value = "Film ID")
    private Integer id;
    @JsonProperty(value = "Release Year")
    private Integer lYear;
    @JsonProperty(value = "Language ID")
    private Integer languageId;
    @JsonProperty(value = "Category ID")
    private Integer categoryId;
    @JsonProperty(value = "Category Name")
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}

package com.mz.data.dao.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DaoFilmViewHql {

    @JsonProperty(value = "Film ID")
    private Integer id;
    @JsonProperty(value = "Film Title")
    private String title;
    @JsonProperty(value = "Release Year")
    private Integer lYear;
    @JsonProperty(value = "Language ID")
    private Integer languageId;
    @JsonProperty(value = "Length")
    private Integer length;
    @JsonProperty(value = "Category ID")
    private Integer categoryId;
    @JsonProperty(value = "Category Name")
    private String categoryName;

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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

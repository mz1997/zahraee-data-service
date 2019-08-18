package com.mz.data.dao.view;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DaoFilmView {

    @JsonProperty(value = "Film ID")
    private Integer id;
    @JsonProperty(value = "Film Title")
    private String title;
    @JsonProperty(value = "Release Year")
    private Integer lYear;
    @JsonProperty(value = "Language ID")
    private Integer languageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}

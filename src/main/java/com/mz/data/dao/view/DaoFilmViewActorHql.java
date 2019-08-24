package com.mz.data.dao.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DaoFilmViewActorHql {



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
    @JsonProperty(value = "Actor ID")
    private Integer actorId;
    @JsonProperty(value = "Actor First Name")
    private String actorFName;
    @JsonProperty(value = "Actor Last Name")
    private String actorLName;

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

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }


    public String getActorFName() {
        return actorFName;
    }

    public void setActorFName(String actorFName) {
        this.actorFName = actorFName;
    }

    public String getActorLName() {
        return actorLName;
    }

    public void setActorLName(String actorLName) {
        this.actorLName = actorLName;
    }
}

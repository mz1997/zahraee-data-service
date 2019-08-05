package com.mz.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

public class Pagination<T extends BaseEntity> {


    public Pagination(Integer totalPages,Integer totalElements ,Integer size ,Integer number ,List<T> content){
        this.totalPages=totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.number = number;
        this.content = content;

    }

    @JsonIgnore
    private Integer totalPages;
    private Integer totalElements;
    private Integer size;
    private Integer number;
    private List<T> content;


    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}

package com.theater.kino.controllers.dto;

import com.theater.kino.domen.Category;

import java.sql.Date;

public class OrdersDto {
    private Integer row;
    private Integer place;
    private Integer sessionPart;
    private Integer category;
    private Date day;
    private String customerFullName;
    private String filmName;

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getSessionPart() {
        return sessionPart;
    }

    public void setSessionPart(Integer sessionPart) {
        this.sessionPart = sessionPart;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}

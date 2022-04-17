package com.theater.kino.domen;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Date;
import java.util.Set;
@Entity
public class Movies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieName;
    private Integer sessionNumber;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<SessionTime> sessionTimes;
    private Boolean activ;
    private Date finshDay;
    private Date beginDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(Integer sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public Set<SessionTime> getSessionTimes() {
        return sessionTimes;
    }

    public void setSessionTimes(Set<SessionTime> sessionTimes) {
        this.sessionTimes = sessionTimes;
    }

    public Boolean getActiv() {
        return activ;
    }

    public void setActiv(Boolean activ) {
        this.activ = activ;
    }

    public Date getFinshDay() {
        return finshDay;
    }

    public void setFinshDay(Date finshDay) {
        this.finshDay = finshDay;
    }

    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }
}

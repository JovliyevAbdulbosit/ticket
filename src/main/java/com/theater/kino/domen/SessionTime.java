package com.theater.kino.domen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SessionTime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date sessionTimeBegin;
    private Date sessionTimeFinsh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSessionTimeBegin() {
        return sessionTimeBegin;
    }

    public void setSessionTimeBegin(Date sessionTimeBegin) {
        this.sessionTimeBegin = sessionTimeBegin;
    }

    public Date getSessionTimeFinsh() {
        return sessionTimeFinsh;
    }

    public void setSessionTimeFinsh(Date sessionTimeFinsh) {
        this.sessionTimeFinsh = sessionTimeFinsh;
    }
}

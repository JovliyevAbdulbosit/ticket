package com.theater.kino.controllers;

import com.theater.kino.domen.CinemaHall;
import com.theater.kino.domen.Enums;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.theater.kino.serveces.CinemaHollServec;

@Repository
@RequestMapping("/api")
public class CinemaHollControler {
    private final CinemaHollServec cinemaHollServecnem;

    public CinemaHollControler(CinemaHollServec cinemaHollServecnem) {
        this.cinemaHollServecnem = cinemaHollServecnem;
    }

//    @GetMapping("/add")
//    public ResponseEntity create(){
//        CinemaHall cinemaHall = new CinemaHall();
//        cinemaHall.setStatus(Enums.FIRSTEMPTY);
//        cinemaHall.setRow(1);
//        cinemaHall.setPlace(1);
//      return new ResponseEntity(cinemaHollServecnem.create(cinemaHall), HttpStatus.OK);
//    }
}

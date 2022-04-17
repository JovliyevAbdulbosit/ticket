package com.theater.kino.serveces;

import com.theater.kino.domen.CinemaHall;
import org.springframework.stereotype.Service;
import com.theater.kino.repositors.CinemaHollRepository;

import java.sql.Date;
import java.util.Optional;
import java.util.List;

@Service
public class CinemaHollServec {
    private final CinemaHollRepository cinemaHollRepository;

    public CinemaHollServec(CinemaHollRepository cinemaHollRepository) {
        this.cinemaHollRepository = cinemaHollRepository;
    }
    public CinemaHall create(CinemaHall cinemaHall){
       return cinemaHollRepository.save(cinemaHall);
    }
public Optional<CinemaHall> findByid(Long id){
       return cinemaHollRepository.findById(id);
}
public List<CinemaHall> all(Date date){
        return cinemaHollRepository.findByDate(date);
}
}


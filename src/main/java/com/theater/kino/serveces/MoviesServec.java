package com.theater.kino.serveces;

import com.theater.kino.domen.CinemaHall;
import com.theater.kino.domen.Movies;
import com.theater.kino.repositors.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class MoviesServec {
    private final MoviesRepository moviesRepository;

    public MoviesServec(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public Optional<Movies> findByid(Long id){
        return moviesRepository.findById(id);
    }

    public Movies craete(Movies movies) {
       return moviesRepository.save(movies);
    }

    public List<Movies> getAll() {
        return moviesRepository.findAll();
    }

    public void delete(Long id) {
        moviesRepository.deleteById(id);
    }
}

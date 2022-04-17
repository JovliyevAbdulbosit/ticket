package com.theater.kino.controllers;

import com.theater.kino.domen.Movies;
import com.theater.kino.serveces.MoviesServec;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Repository
@RequestMapping("/api")
public class MoviesController {
    private final MoviesServec moviesServec;

    public MoviesController(MoviesServec moviesServec) {
        this.moviesServec = moviesServec;
    }
    @PostMapping("/add/film")
    public ResponseEntity createMovie(@RequestBody Movies movies){
        return ResponseEntity.ok(moviesServec.craete(movies));
    }
    @GetMapping("/all/film")
    public ResponseEntity<List> getAllFilm(){
        return ResponseEntity.ok(moviesServec.getAll());
    }
    @PutMapping("/update/film")
    public ResponseEntity updateMovie(@RequestBody Movies movies){
        return ResponseEntity.ok(moviesServec.craete(movies));
    }
    @DeleteMapping("/delete/film/{id}")
    public ResponseEntity deleteFilm(@PathVariable("id") Long id){
        moviesServec.delete(id);
        return ResponseEntity.ok("delete");
    }
}

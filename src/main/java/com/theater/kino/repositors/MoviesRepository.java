package com.theater.kino.repositors;

import com.theater.kino.domen.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {
    Movies findByMovieName(String mov);
    Optional<Movies> findById(Long id);
}

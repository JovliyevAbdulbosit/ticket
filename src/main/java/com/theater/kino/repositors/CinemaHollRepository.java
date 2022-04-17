package com.theater.kino.repositors;

import com.theater.kino.domen.Category;
import com.theater.kino.domen.CinemaHall;
import com.theater.kino.domen.Enums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaHollRepository extends JpaRepository<CinemaHall,Long> {
    boolean existsByRowAndStatusAndPlaceAndCategoryAndSessionPartAndDate(
            Integer row, Enums enums, Integer place, Category ctg, Integer sessNum , Date date);
    CinemaHall findByRowAndStatusAndPlaceAndCategoryAndSessionPartAndDate(
            Integer row,Enums enums , Integer place, Category ctg, Integer sessNum ,Date date
    );
    Optional<CinemaHall> findById(Long id);


    List<CinemaHall> findByDate(Date date);
}

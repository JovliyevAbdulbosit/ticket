package com.theater.kino.repositors;

import com.theater.kino.domen.SessionTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Sessionrepository extends JpaRepository<SessionTime, Long> {
 Optional<SessionTime> findById(Integer id);
}

package com.theater.kino.serveces;

import com.theater.kino.domen.Movies;
import com.theater.kino.domen.SessionTime;
import com.theater.kino.repositors.Sessionrepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionServec {
    private final Sessionrepository sessionrepository;

    public SessionServec(Sessionrepository sessionrepository) {
        this.sessionrepository = sessionrepository;
    }
    public Optional<SessionTime> findByid(Integer id){
        return sessionrepository.findById(id);
    }
}

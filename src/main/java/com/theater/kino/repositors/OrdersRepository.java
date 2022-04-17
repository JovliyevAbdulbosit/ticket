package com.theater.kino.repositors;

import com.theater.kino.domen.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface OrdersRepository extends JpaRepository<Orders , Long> {
    List<Orders>  findByActiveAndSell(Boolean ative,Boolean sell);
}

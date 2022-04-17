package com.theater.kino;

import com.theater.kino.domen.CinemaHall;
import com.theater.kino.domen.Enums;
import com.theater.kino.domen.Orders;
import com.theater.kino.domen.SessionTime;
import com.theater.kino.repositors.Sessionrepository;
import com.theater.kino.serveces.CinemaHollServec;
import com.theater.kino.serveces.OrdersServec;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
@Component

public class TestCompanenta {
    private final OrdersServec ordersServec;
    private final Sessionrepository sessionrepository;
    private final CinemaHollServec cinemaHollServec;

    public TestCompanenta(OrdersServec ordersServec, Sessionrepository sessionrepository, CinemaHollServec cinemaHollServec) {
        this.ordersServec = ordersServec;
        this.sessionrepository = sessionrepository;
        this.cinemaHollServec = cinemaHollServec;
    }


    @Scheduled(fixedRate = 1800000)
    public void checkOrders(){
        System.out.println("keldi");
        Date now = new Date();
   List<Orders> order = ordersServec.findByactivandSell(true,false);
        for (Orders i :order) {
         Optional<CinemaHall> place = cinemaHollServec.findByid(i.getPlaceId());
         Optional<SessionTime> time =  sessionrepository.findById( place.get().getSessionPart());
         if(!checkDay(place.get().getDate(),time.get().getSessionTimeBegin())){
             place.get().setStatus(Enums.EMPTY);
             cinemaHollServec.create(place.get());
            }
        }
}
public Boolean checkDay(Date date,Date time){
        Date now = new Date();
        if(now.getMonth()<date.getMonth()){
                return true;
        }else if(now.getMonth() == date.getMonth()){
            if(now.getDay() < date.getDay()){ return true;}

            else if(now.getDay() == date.getDay()){
                if(now.getTime() < time.getTime()-1){return true;}
                else {return false;}
            }
        }else {return false;}
        return false;
}
     @Scheduled(cron = "0 0 23 * * *")
    public void placesUpdtae(){
         Date now = new  Date();
       java.sql.Date day =  new java.sql.Date(now.getTime());
       List<CinemaHall> places = cinemaHollServec.all(day);
         for (CinemaHall i:places
              ) {

             i.setStatus(Enums.EMPTY);
             i.setDate(new java.sql.Date(now.getTime()+86400000));
             cinemaHollServec.create(i);
         }
    }


}

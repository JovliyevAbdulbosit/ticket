package com.theater.kino.serveces;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.theater.kino.controllers.dto.OrdersDto;
import com.theater.kino.domen.*;
import com.theater.kino.repositors.CinemaHollRepository;
import com.theater.kino.repositors.MoviesRepository;
import com.theater.kino.repositors.OrdersRepository;
import com.theater.kino.repositors.Sessionrepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.theater.kino.controllers.dto.GenerateQRCode.generateQRcode;

@Service
public class OrdersServec {
    private final OrdersRepository ordersRepository;
   private final MoviesRepository moviesRepository;
   private final CinemaHollRepository cinemaHollRepository;
    private final Sessionrepository sessionrepository;

    public OrdersServec(OrdersRepository ordersRepository, MoviesRepository moviesRepository, CinemaHollRepository cinemaHollRepository, Sessionrepository sessionrepository) {
        this.ordersRepository = ordersRepository;
        this.moviesRepository = moviesRepository;
        this.cinemaHollRepository = cinemaHollRepository;
        this.sessionrepository = sessionrepository;

    }

public Object craete(OrdersDto ordersDto) throws IOException, WriterException {
        if(cinemaHollRepository.existsByRowAndStatusAndPlaceAndCategoryAndSessionPartAndDate(
                ordersDto.getRow(),Enums.EMPTY,
                ordersDto.getPlace(),Category.values()[ordersDto.getCategory()],
                ordersDto.getSessionPart(), ordersDto.getDay())){


            Orders order = new Orders();
            CinemaHall holl = cinemaHollRepository.findByRowAndStatusAndPlaceAndCategoryAndSessionPartAndDate(
                            ordersDto.getRow(),Enums.EMPTY,
                            ordersDto.getPlace(),Category.values()[ordersDto.getCategory()],
                            ordersDto.getSessionPart(), ordersDto.getDay());
            Movies mov = moviesRepository.findByMovieName(ordersDto.getFilmName());
            order.setPlaceId(holl.getId());
            order.setSell(false);
            order.setActive(true);
            order.setCustomerFullName(ordersDto.getCustomerFullName());
            order.setMoviesId(mov.getId());
            order.setSesionId(ordersDto.getSessionPart());
           holl.setStatus(Enums.ORDERED);
           ordersRepository.save(order);
           cinemaHollRepository.save(holl);

           //qr generte
            String str= order.getId()+")" +ordersDto.getCustomerFullName()+ " date:  " +ordersDto.getDay()+" session: "+ordersDto.getSessionPart();

            String path = String.format( "D:/%s.png",order.getId());

            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

            hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            generateQRcode(str, path, charset, hashMap, 200, 200);


           return order.getId();
        }

        return "bu joy band qilingan";

}
public List<Orders> findByactivandSell(boolean active , boolean sell){
        return ordersRepository.findByActiveAndSell(active,sell);
}




}

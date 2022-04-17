package com.theater.kino.controllers;

import com.google.zxing.WriterException;
import com.theater.kino.controllers.dto.OrdersDto;
import com.theater.kino.serveces.OrdersServec;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.util.UriEncoder;

import java.io.IOException;

@Repository
@RequestMapping("/api")
public class OrdersController {
    private final OrdersServec ordersServec;

    public OrdersController(OrdersServec ordersServec) {
        this.ordersServec = ordersServec;
    }

    @PostMapping("/order")
    public ResponseEntity craete(@RequestBody OrdersDto ordersDto) throws IOException, WriterException {
        Object id = ordersServec.craete(ordersDto);
        if(id instanceof Long){
        return    ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION ,"attachment;fileName=\""+ "bilet")
                .contentType(MediaType.IMAGE_PNG)
                .body(new FileUrlResource(String.format("D:/%s.png",id)));}
    return ResponseEntity.ok(id);
    }


}

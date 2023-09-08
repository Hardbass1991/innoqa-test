package com.innoqa.test.controller;

import com.innoqa.test.model.Pricelist;
import com.innoqa.test.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/pricelists")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @GetMapping("/all")
    public ResponseEntity<List<Pricelist>> getAllPricelists(){
        return status(HttpStatus.OK).body(pricelistService.getAllPricelists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pricelist> getPricelist(@PathVariable("id") Long id){
        return status(HttpStatus.OK).body(pricelistService.getPricelist(id));
    }

    @GetMapping()
    public ResponseEntity<List<Pricelist>> getPricelistsCustom(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                   LocalDateTime queryDateTime,
                                                               Long queryBrandId,
                                                               Long queryProductId) {

        return status(HttpStatus.OK).body(pricelistService.getPricelistCustom(queryDateTime, queryBrandId, queryProductId));
    }
}

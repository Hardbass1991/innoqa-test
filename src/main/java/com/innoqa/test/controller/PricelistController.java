package com.innoqa.test.controller;

import com.innoqa.test.dto.PricelistRequest;
import com.innoqa.test.model.Brand;
import com.innoqa.test.model.Pricelist;
import com.innoqa.test.model.Product;
import com.innoqa.test.service.BrandService;
import com.innoqa.test.service.PricelistService;
import com.innoqa.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/pricelists")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Pricelist>> getAllPricelists(){
        return status(HttpStatus.OK).body(pricelistService.getAllPricelists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pricelist> getPricelist(@PathVariable("id") Long id){
        return status(HttpStatus.OK).body(pricelistService.getPricelist(id));
    }

    @GetMapping("/byBrandId")
    public ResponseEntity<List<Pricelist>> getPricelistsByBrandId(@RequestParam Long brandId){
        return status(HttpStatus.OK).body(pricelistService.getPricelistsByBrandId(brandId));
    }

    @PostMapping()
    public ResponseEntity<List<Pricelist>> postPricelist(@RequestBody PricelistRequest pricelistRequest){
        Pricelist newPricelist = new Pricelist();
        newPricelist.setBrand(brandService.getBrand(pricelistRequest.getBrandId()));
        List<Product> products = new ArrayList<Product>();
        for(Long productId: pricelistRequest.getProductIds()) {
            Product product = productService.getProduct(productId);
            products.add(product);
        }
        newPricelist.setProducts(products);
        newPricelist.setPriority(pricelistRequest.getPriority());
        newPricelist.setPrice(pricelistRequest.getPrice());
        newPricelist.setCurr(pricelistRequest.getCurr());
        pricelistService.savePricelist(newPricelist);
        return status(HttpStatus.OK).body(pricelistService.getAllPricelists());
    }
}

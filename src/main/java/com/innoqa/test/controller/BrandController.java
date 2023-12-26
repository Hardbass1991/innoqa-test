package com.innoqa.test.controller;

import com.innoqa.test.model.Brand;
import com.innoqa.test.model.Pricelist;
import com.innoqa.test.service.BrandService;
import com.innoqa.test.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    public ResponseEntity<List<Brand>> getAllBrands(){
        return status(HttpStatus.OK).body(brandService.getAllBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable("id") Long id){
        return status(HttpStatus.OK).body(brandService.getBrand(id));
    }

    @PostMapping()
    public ResponseEntity<List<Brand>> postBrand(@RequestBody Brand brand){
        brandService.saveBrand(brand);
        return status(HttpStatus.OK).body(brandService.getAllBrands());
    }
}

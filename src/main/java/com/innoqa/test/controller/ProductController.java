package com.innoqa.test.controller;

import com.innoqa.test.model.Brand;
import com.innoqa.test.model.Product;
import com.innoqa.test.service.BrandService;
import com.innoqa.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return status(HttpStatus.OK).body(productService.getProduct(id));
    }

    @PostMapping()
    public ResponseEntity<List<Product>> postProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return status(HttpStatus.OK).body(productService.getAllProducts());
    }
}

package com.innoqa.test.service;

import com.innoqa.test.model.Brand;
import com.innoqa.test.model.Product;
import com.innoqa.test.repository.BrandRepository;
import com.innoqa.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}

package com.innoqa.test.service;

import com.innoqa.test.model.Brand;
import com.innoqa.test.model.Pricelist;
import com.innoqa.test.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrand(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        return optionalBrand.get();
    }

    public void saveBrand(Brand brand){
        brandRepository.save(brand);
    }
}

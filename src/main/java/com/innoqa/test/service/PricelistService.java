package com.innoqa.test.service;

import com.innoqa.test.dto.PricelistRequest;
import com.innoqa.test.model.Pricelist;
import com.innoqa.test.repository.PricelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    public List<Pricelist> getAllPricelists() {
        return pricelistRepository.findAll();
    }

    public Pricelist getPricelist(Long id) {
        Optional<Pricelist> optionalPricelist = pricelistRepository.findById(id);
        return optionalPricelist.get();
    }

    public List<Pricelist> getPricelistsByBrandId(Long id) {
        return pricelistRepository.findByBrandId(id);
    }

    public void savePricelist(Pricelist pricelist){
        pricelistRepository.save(pricelist);
    }
}

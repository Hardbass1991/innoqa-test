package com.innoqa.test.dto;

import com.innoqa.test.model.Brand;
import com.innoqa.test.model.Product;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
public class PricelistRequest {
    private Long brandId;
    private List<Long> productIds;
    private Integer priority;
    private Float price;
    private String curr;
}

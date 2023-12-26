package com.innoqa.test.dto;

import com.innoqa.test.model.Brand;
import com.innoqa.test.model.Product;
import jakarta.persistence.*;

public class PricelistRequest {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId", referencedColumnName = "brandId")
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    private Integer priority;
    private Float price;
    private String curr;
}

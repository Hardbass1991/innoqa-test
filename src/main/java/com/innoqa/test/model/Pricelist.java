package com.innoqa.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pricelists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pricelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(index=1)
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand", referencedColumnName = "brandId")
    private Brand brand;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product", referencedColumnName = "productId")
    private List<Product> products;

    private Integer priority;
    private Float price;
    private String curr;
}

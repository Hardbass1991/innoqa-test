package com.innoqa.test.repository;

import com.innoqa.test.model.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {
    @Query(nativeQuery = true,
            value = """
            SELECT * 
            FROM Pricelists p 
            WHERE (:queryDateTime BETWEEN p.start_Date AND p.end_Date)
            AND :queryBrandId = p.brand_id
            AND :queryProductId = p.product_id;
            """)
    public List<Pricelist> findByDates(LocalDateTime queryDateTime, Long queryBrandId, Long queryProductId);
}

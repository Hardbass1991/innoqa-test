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
            WHERE :queryBrandId = p.brand_id
            """)
    public List<Pricelist> findByBrandId(Long queryBrandId);
}

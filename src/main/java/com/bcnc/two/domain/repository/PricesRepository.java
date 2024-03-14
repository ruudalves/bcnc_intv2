package com.bcnc.two.domain.repository;

import com.bcnc.two.domain.Prices;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PricesRepository {
    Optional<Prices> findByDateRangeAndBrandAndProduct(LocalDateTime date, int productId, int brandId);
}

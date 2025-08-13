package com.bcnc.two.domain.out.repository;

import com.bcnc.two.domain.entity.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PricesRepository {
    Optional<Price> findByDateRangeAndProductIdAndBrandId(LocalDateTime date, int productId, int brandId);
}

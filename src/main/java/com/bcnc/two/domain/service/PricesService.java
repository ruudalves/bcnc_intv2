package com.bcnc.two.domain.service;

import com.bcnc.two.domain.Prices;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public interface PricesService {

    Optional<Prices> findByValues(LocalDateTime dateOfApplication, int productId, int brandId);
}

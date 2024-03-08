package com.bcnc.two.service;

import com.bcnc.two.entities.Prices;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public interface PricesService {

    Optional<Prices> findByValues(LocalDateTime dateOfApplication, int productId, int brandId);
    String getPetitionDescribed(LocalDateTime dateOfApplication, int productId, int brandId) throws NullPointerException;
}

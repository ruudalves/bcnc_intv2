package com.bcnc.two.infrastructure.repository;

import com.bcnc.two.domain.Prices;
import com.bcnc.two.domain.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Primary
@Component
public class H2PriceRepository implements PricesRepository {

    private final SpringDataH2PriceRepository springDataH2PriceRepository;

    @Autowired
    public H2PriceRepository(final SpringDataH2PriceRepository springDataH2PriceRepository){
        this.springDataH2PriceRepository=springDataH2PriceRepository;
    }
    @Override
    public Optional<Prices> findByDateRangeAndBrandAndProduct(LocalDateTime date, int productId, int brandId) {
        return springDataH2PriceRepository.findOne(SpringDataH2PriceRepository.findByDateRangeAndBrandAndProduct(date,productId,brandId));
    }
}

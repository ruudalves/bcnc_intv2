package com.bcnc.two.domain.service.impl;

import com.bcnc.two.domain.in.query.BrandQuery;
import com.bcnc.two.domain.in.query.PricesQuery;
import com.bcnc.two.domain.in.query.params.SearchPricesByDateRangeAndProductAndBrandParams;
import com.bcnc.two.domain.out.repository.PricesRepository;
import com.bcnc.two.domain.entity.Brand;
import com.bcnc.two.domain.entity.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PricesQuery {

    private final BrandQuery brandQuery;

    private final PricesRepository pricesRepository;

    @Override
    public Optional<Price> findByDateAndProductIdAndBrandId(SearchPricesByDateRangeAndProductAndBrandParams params) {
        Optional<Brand> optionalBrand = brandQuery.query(params.brandId());
        if(optionalBrand.isPresent()) {
            return pricesRepository.findByDateRangeAndProductIdAndBrandId(params.date(), params.productId(), params.brandId());
        }
        else{
            return Optional.empty();
        }
    }

}

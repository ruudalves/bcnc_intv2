package com.bcnc.two.domain.service.impl;

import com.bcnc.two.domain.repository.PricesRepository;
import com.bcnc.two.domain.Brand;
import com.bcnc.two.domain.Prices;
import com.bcnc.two.domain.service.BrandService;
import com.bcnc.two.domain.service.PricesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PricesServiceImpl implements PricesService {


    private final BrandService brandService;

    private final PricesRepository pricesRepository;

    @Override
    public Optional<Prices> findByValues(LocalDateTime dateOfApplication, int productId, int brandId) {
        Optional<Brand> optionalBrand = brandService.getBrandById(brandId);
        if(optionalBrand.isPresent()) {
            return pricesRepository.findByDateRangeAndBrandAndProduct(dateOfApplication, productId, brandId);
        }
        else{
            return Optional.empty();
        }
    }

}

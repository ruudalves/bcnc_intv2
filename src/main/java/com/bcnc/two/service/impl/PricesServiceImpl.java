package com.bcnc.two.service.impl;

import com.bcnc.two.entities.Brand;
import com.bcnc.two.entities.Prices;
import com.bcnc.two.repository.PricesRepository;
import com.bcnc.two.service.BrandService;
import com.bcnc.two.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private BrandService brandService;
    @Autowired
    private PricesRepository pricesRepository;


    @Override
    public Optional<Prices> findByValues(LocalDateTime dateOfApplication, int productId, int brandId) {
        Optional<Brand> optionalBrand = brandService.getBrandById(brandId);
        if(optionalBrand.isPresent()) {
            Specification<Prices> spec = PricesRepository.findByDateRangeAndBrandAndProduct(dateOfApplication, productId, brandId);
            return pricesRepository.findOne(spec);
        }
        else{
            return Optional.empty();
        }
    }

    @Override

    public String getPetitionDescribed(LocalDateTime dateOfApplication, int productId, int brandId) {

        Optional<Prices> prices = findByValues(dateOfApplication, productId, brandId);
        if (prices.isEmpty()) {
            return "";
        } else {
           return prices.get().getPrice().toString();
        }

    }
}

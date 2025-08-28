package com.bcnc.two.domain.service.impl;

import com.bcnc.two.domain.in.query.BrandQuery;
import com.bcnc.two.domain.out.repository.BrandRepository;
import com.bcnc.two.domain.entity.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class BrandServiceImpl implements BrandQuery {

    private BrandRepository brandRepository;

    @Override
    public Optional<Brand> query(int brandId) {
        return brandRepository.findById((long) brandId);
    }
}

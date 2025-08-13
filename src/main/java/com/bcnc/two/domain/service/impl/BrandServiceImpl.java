package com.bcnc.two.domain.service.impl;

import com.bcnc.two.domain.in.query.BrandQuery;
import com.bcnc.two.domain.out.repository.BrandRepository;
import com.bcnc.two.domain.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BrandServiceImpl implements BrandQuery {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Optional<Brand> query(int brand_Id) {
        return brandRepository.findById((long) brand_Id);
    }
}

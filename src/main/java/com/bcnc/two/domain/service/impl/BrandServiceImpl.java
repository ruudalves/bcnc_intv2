package com.bcnc.two.domain.service.impl;

import com.bcnc.two.domain.repository.BrandRepository;
import com.bcnc.two.domain.service.BrandService;
import com.bcnc.two.domain.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Optional<Brand> getBrandById(int brand_Id) {
        return brandRepository.findById((long) brand_Id);
    }
}

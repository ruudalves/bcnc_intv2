package com.bcnc.two.service.impl;

import com.bcnc.two.repository.BrandRepository;
import com.bcnc.two.service.BrandService;
import com.bcnc.two.entities.Brand;
import lombok.AllArgsConstructor;
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

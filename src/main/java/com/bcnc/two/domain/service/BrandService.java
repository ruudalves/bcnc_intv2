package com.bcnc.two.domain.service;

import com.bcnc.two.domain.Brand;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface BrandService {
    Optional<Brand> getBrandById(int brand_Id);
}

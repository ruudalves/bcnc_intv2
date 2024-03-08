package com.bcnc.two.service;

import com.bcnc.two.entities.Brand;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface BrandService {
    Optional<Brand> getBrandById(int brand_Id);
}

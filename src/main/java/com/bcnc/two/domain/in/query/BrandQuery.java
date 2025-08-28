package com.bcnc.two.domain.in.query;

import com.bcnc.two.domain.entity.Brand;

import java.util.Optional;

public interface BrandQuery {
    Optional<Brand> query(int brandId);
}

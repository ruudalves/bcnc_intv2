package com.bcnc.two.domain.out.repository;

import com.bcnc.two.domain.entity.Brand;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface    BrandRepository {
    Optional<Brand> findById(Long id);
}

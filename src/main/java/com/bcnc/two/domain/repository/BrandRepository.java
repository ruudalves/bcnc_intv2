package com.bcnc.two.domain.repository;

import com.bcnc.two.domain.Brand;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface    BrandRepository {
    Optional<Brand> findById(Long id);
}

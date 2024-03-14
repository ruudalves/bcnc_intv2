package com.bcnc.two.infrastructure.repository;

import com.bcnc.two.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataH2BrandRepository extends JpaRepository<Brand,Long>, JpaSpecificationExecutor<Brand> {
}

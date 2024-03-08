package com.bcnc.two.repository;

import com.bcnc.two.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long>, JpaSpecificationExecutor<Brand> {
}

package com.bcnc.two.infrastructure.repository;

import com.bcnc.two.domain.Brand;
import com.bcnc.two.domain.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Primary
@Component
public class H2BrandRepository implements BrandRepository {

    private final SpringDataH2BrandRepository brandRepository;

    @Autowired

    public H2BrandRepository(final SpringDataH2BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }
}

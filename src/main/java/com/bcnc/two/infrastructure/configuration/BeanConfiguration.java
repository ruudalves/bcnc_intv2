package com.bcnc.two.infrastructure.configuration;

import com.bcnc.two.TwoApplication;
import com.bcnc.two.domain.repository.PricesRepository;
import com.bcnc.two.domain.service.BrandService;
import com.bcnc.two.domain.service.PricesService;
import com.bcnc.two.domain.service.impl.PricesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TwoApplication.class)
public class BeanConfiguration {

    @Bean
    PricesService pricesService(final BrandService brandService, final PricesRepository pricesRepository){
        return new PricesServiceImpl(brandService, pricesRepository);
    }
}

package com.bcnc.two.infrastructure.configuration;

import com.bcnc.two.TwoApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TwoApplication.class)
public class BeanConfiguration {

}

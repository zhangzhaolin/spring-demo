package com.shiwa.spring.config;

import com.shiwa.spring.product.ProductHelloServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zhang
 */
@Configuration
@Profile(value = "product")
@ComponentScan(basePackageClasses = ProductHelloServiceImpl.class)
public class ProductConfiguration {
}

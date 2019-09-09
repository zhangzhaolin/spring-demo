package com.shiwa.spring.config;

import com.shiwa.spring.dev.DevHelloServiceImpl;
import com.shiwa.spring.product.ProductHelloServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhang
 */
@Configuration
@ComponentScan(basePackageClasses = {RootConfiguration.class})
public class RootConfiguration {
}

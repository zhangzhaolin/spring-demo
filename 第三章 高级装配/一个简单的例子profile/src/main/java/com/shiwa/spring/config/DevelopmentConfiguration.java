package com.shiwa.spring.config;

import com.shiwa.spring.dev.DevHelloServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zhang
 */
@Configuration
@Profile(value = "development")
@ComponentScan(basePackageClasses = DevHelloServiceImpl.class)
public class DevelopmentConfiguration {
}

package main.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiwa
 */

@Configuration
@ComponentScan(basePackages = "main.example")
public class SpringRootConfig {

    @Bean
    public DevelopmentProfileConfig developmentProfileConfig(){
        return new DevelopmentProfileConfig();
    }

}

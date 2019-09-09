package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DataConfig.class})
@ComponentScan(basePackages = {"dao"})
public class RootConfig {



}

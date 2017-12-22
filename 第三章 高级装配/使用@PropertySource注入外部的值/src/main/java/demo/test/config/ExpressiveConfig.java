package demo.test.config;

import demo.test.compactdisc.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/app.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment environment;

    @Bean
    public BlankDisc disc(){
        return new BlankDisc(
                environment.getProperty("disc.title"),
                environment.getProperty("disc.artist")
        );
    }

}

package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiwa
 */

@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc(){
        return new SgtPappers();
    }
}

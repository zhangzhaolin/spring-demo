package soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.compactdisc.SgtPeppers;

/**
 * @author shiwa
 */

@Configuration
@Service
public class CDConfig {

    @Bean
    public CompactDisc compactDisc(){
        return new SgtPeppers();
    }
}

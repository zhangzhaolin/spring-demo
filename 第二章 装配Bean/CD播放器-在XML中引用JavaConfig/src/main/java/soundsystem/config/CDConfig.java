package soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.compactdisc.SgtPeppers;

/**
 * @author shiwa
 */

@Component
public class CDConfig {

    @Bean
    public CompactDisc compactDisc(){
        return new SgtPeppers();
    }
}

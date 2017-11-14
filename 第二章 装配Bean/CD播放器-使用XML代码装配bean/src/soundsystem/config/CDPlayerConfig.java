package soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.compactdisc.SgtPeppers;
import soundsystem.mediaplayer.CDPlayer;

/**
 * @author shiwa
 */

@Configuration
public class CDPlayerConfig {

    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }

}

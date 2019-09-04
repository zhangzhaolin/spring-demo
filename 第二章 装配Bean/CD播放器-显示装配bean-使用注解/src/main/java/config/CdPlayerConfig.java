package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiwazi
 */
@Configuration
public class CdPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        List<String> tracks = new ArrayList<String>();
        tracks.add("tracks1");
        tracks.add("tracks2");
        tracks.add("tracks3");
        return new SgtPeppers("寻宝游戏", "vae", tracks);
    }

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        return new CdPlayer(compactDisc);
    }

}

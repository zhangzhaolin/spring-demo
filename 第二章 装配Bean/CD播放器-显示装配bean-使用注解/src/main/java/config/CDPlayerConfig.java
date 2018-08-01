package main.java.config;

import main.java.soundsystem.CDPlayer;
import main.java.soundsystem.CompactDisc;
import main.java.soundsystem.MediaPlayer;
import main.java.soundsystem.SgtPeppers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        List<String> tracks = new ArrayList<String>();
        tracks.add("tracks1");
        tracks.add("tracks2");
        tracks.add("tracks3");
        return new SgtPeppers("寻宝游戏","vae",tracks);
    }

    @Bean
    public MediaPlayer mediaPlayer(){
        return new CDPlayer(sgtPeppers());
    }

}

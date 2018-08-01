package main.java;

import main.java.config.CDPlayerConfig;
import main.java.soundsystem.MediaPlayer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDPlayerMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        MediaPlayer mediaPlayer =  (MediaPlayer)context.getBean("mediaPlayer");
        mediaPlayer.play();
    }

}

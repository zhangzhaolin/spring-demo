package soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import soundsystem.config.CDPlayerConfig;
import soundsystem.mediaplayer.CDPlayer;
import soundsystem.mediaplayer.MediaPlayer;

import java.util.Date;
import java.util.Scanner;

public class CDPlayerMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CDPlayer cdPlayer = (CDPlayer)context.getBean("lonelyHeartsClub");
        cdPlayer.play();
    }

}

package main.java;

import main.java.soundsystem.MediaPlayer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class CDPlayerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/java/cdconfig.xml");
        MediaPlayer mediaPlayer = (MediaPlayer) context.getBean("mediaPlayer");
        mediaPlayer.play();
    }

}

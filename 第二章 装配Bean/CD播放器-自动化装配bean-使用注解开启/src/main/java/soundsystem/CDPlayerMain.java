package main.java.soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import main.java.soundsystem.config.CDPlayerConfig;
import main.java.soundsystem.mediaplayer.CDPlayer;

public class CDPlayerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext clcc= new ClassPathXmlApplicationContext();


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CDPlayer cdPlayer = (CDPlayer)context.getBean("lonelyHeartsClub");
        cdPlayer.play();
    }

}

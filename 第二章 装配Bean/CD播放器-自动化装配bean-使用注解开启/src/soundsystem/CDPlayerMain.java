package soundsystem;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import soundsystem.config.CDPlayerConfig;
import soundsystem.mediaplayer.CDPlayer;
import soundsystem.mediaplayer.MediaPlayer;

import java.util.Date;
import java.util.Scanner;

public class CDPlayerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext clcc= new ClassPathXmlApplicationContext();


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CDPlayer cdPlayer = (CDPlayer)context.getBean("lonelyHeartsClub");
        cdPlayer.play();
    }

}

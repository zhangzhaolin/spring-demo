package soundsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import soundsystem.config.CdPlayerConfig;
import soundsystem.mediaplayer.CdPlayer;

public class CdPlayerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext clcc = new ClassPathXmlApplicationContext();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CdPlayerConfig.class);
        CdPlayer cdPlayer = (CdPlayer) context.getBean("lonelyHeartsClub");
        System.out.println(cdPlayer.play());
    }

}

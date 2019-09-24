import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import soundsystem.*;

public class Main {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        CompactDisc compactDisc = (CompactDisc) context.getBean("blankDisc");
        TrackCounter trackCounter = (TrackCounter) context.getBean("trackCounter");
        compactDisc.playTrack(0);
        compactDisc.playTrack(0);
        compactDisc.playTrack(1);
        compactDisc.play();
        System.out.println(trackCounter.getPlayCount(0));
        System.out.println(trackCounter.getPlayCount(1));
    }
}

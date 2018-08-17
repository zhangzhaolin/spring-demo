import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import soundsystem.*;

public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDConfig.class);
        CompactDisc compactDisc = (CompactDisc)context.getBean("blankDisc");
        TrackCounter trackCounter = (TrackCounter)context.getBean("trackCounter");
        compactDisc.playTrack(0);
        compactDisc.playTrack(0);
        compactDisc.playTrack(1);
        System.out.println(trackCounter.getPlayCount(0));
        System.out.println(trackCounter.getPlayCount(1));
    }
}

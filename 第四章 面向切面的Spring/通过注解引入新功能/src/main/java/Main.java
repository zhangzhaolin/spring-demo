import concert.EncoreableIntroducer;
import concert.MusicPerformance;
import concert.Performance;
import concert.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        EncoreableIntroducer performance = (EncoreableIntroducer) context.getBean("encoreableIntroducer");
        // ! performance.encoreable.performEncore();
    }
}

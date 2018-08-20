import concert.MusicPerformance;
import concert.Performance;
import concert.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Performance performance = (Performance) context.getBean("musicPerformance");
        performance.perform();
    }
}

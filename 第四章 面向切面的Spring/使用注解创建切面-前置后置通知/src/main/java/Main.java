import concert.ConcertConfig;
import concert.Performance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
        Performance musicPerformance = (Performance) context.getBean("musicPerformance");
        musicPerformance.perform();
    }
}

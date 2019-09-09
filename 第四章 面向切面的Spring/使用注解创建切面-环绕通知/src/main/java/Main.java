import concert.ConcertConfig;
import concert.Performance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
        Performance performance = (Performance) context.getBean("performance");
        performance.perform();
    }
}

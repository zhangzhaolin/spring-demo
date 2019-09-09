import concert.Performance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Performance performance = (Performance) context.getBean("musicPerformance");
        performance.perform();
    }
}

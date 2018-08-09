package springinaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springinaction.knights.BraveKnight;

public class KnightMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/knight.xml");
        BraveKnight braveKnight = (BraveKnight) context.getBean("braveKnight");
        braveKnight.embarkOnQuest();
    }
}

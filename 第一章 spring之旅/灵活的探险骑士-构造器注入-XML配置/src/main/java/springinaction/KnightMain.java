package springinaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springinaction.knights.BraveKnight;

/**
 * @author zhang
 */
public class KnightMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        BraveKnight braveKnight = (BraveKnight) context.getBean("knight");
        braveKnight.embarkOnQuest();
    }
}

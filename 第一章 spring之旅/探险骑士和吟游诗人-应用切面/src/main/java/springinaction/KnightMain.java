package springinaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springinaction.knights.Knight;

public class KnightMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/Knight.xml");
        Knight braveKnight = (Knight)context.getBean("knight");
        braveKnight.embarkOnQuest();
    }
}

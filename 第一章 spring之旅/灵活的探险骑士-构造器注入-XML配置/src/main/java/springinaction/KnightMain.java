package springinaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springinaction.knights.Knight;

/**
 * @author zhang
 */
public class KnightMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();
    }
}

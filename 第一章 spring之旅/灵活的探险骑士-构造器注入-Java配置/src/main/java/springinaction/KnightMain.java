package springinaction;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springinaction.knights.Knight;

/**
 * @author shiwa
 */
public class KnightMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("springinaction/config");
        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();
    }
}

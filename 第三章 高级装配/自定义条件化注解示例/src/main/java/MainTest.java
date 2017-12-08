import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shiwa
 */


public class MainTest {

    public static void main(String[] args) {
        System.setProperty("message","---hahaha");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionClass.class);
        try {
            context.getBean(HelloWorld.class).print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

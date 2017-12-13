import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shiwa
 */


public class MainTest {

    public static void main(String[] args) {
        System.setProperty("message","This is a message from me");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionClass.class);
        try {
            context.getBean(HelloWorld.class).print();
            System.out.println(context.getEnvironment().getProperty("message"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shiwa
 */
public class MainTest {

    public static void main(String []args){

        System.setProperty("magic","true");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MagicBeanConfig.class);

        System.out.println(context.containsBean("magicBean"));

        context.close();
    }
}

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

/**
 * @author shiwa
 */

public class MainTest {

    public static void main(String []args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ProfileConfig.class);
        context.getEnvironment().setActiveProfiles("dev");
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);

        System.out.println(demoBean.getContent());

        context.close();

    }
}

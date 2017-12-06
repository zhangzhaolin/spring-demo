import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shiwa
 */

public class MainTest {

    public static void main(String []args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);

        System.out.println(demoBean.getContent());

        context.close();

    }
}

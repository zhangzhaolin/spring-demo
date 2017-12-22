package demo.test;


import demo.test.compactdisc.BlankDisc;
import demo.test.config.ExpressiveConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String []args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);

        BlankDisc blankDisc = context.getBean(BlankDisc.class);

        blankDisc.play();

        context.close();
    }

}

import com.springdemo.config.ExpressiveConfig;
import com.springdemo.soundsystem.BlankDisc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);
        BlankDisc blankDisc = (BlankDisc)context.getBean("blankDisc");
        blankDisc.play();
    }
}

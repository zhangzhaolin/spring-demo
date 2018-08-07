import com.springdemo.soundsystem.BlankDisc;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("blankDisc.xml");
        BlankDisc blankDisc = (BlankDisc) context.getBean("blankDisc");
        blankDisc.play();
    }
}

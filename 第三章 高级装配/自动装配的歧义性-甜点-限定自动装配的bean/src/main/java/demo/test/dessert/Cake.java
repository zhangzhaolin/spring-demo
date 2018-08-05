package demo.test.dessert;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class Cake implements Dessert {

    public void play() {
        System.out.println("这是 cake");
    }
}

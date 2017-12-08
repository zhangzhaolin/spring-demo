package main.java.dessert;
import main.java.inter.Cold;
import main.java.inter.Creamy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
@Cold
@Creamy
public class IceCream implements Dessert {

    public void play() {
        System.out.println("这是 IceCream");
    }
}

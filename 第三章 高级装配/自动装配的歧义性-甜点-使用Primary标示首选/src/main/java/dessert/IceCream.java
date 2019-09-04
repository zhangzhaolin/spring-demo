package dessert;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Primary
@Component
public class IceCream implements Dessert {
    @Override
    public void play() {
        System.out.println("这是 IceCream");
    }
}

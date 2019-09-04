package dessert;

import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class Cookie implements Dessert {
    @Override
    public void play() {
        System.out.println("这是 cookie");
    }
}

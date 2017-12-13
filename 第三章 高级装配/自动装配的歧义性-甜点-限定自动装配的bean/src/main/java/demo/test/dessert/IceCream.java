package demo.test.dessert;

import demo.test.inter.*;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 * 冰淇淋 类
 */

@Component
@Cold
@Creamy
public class IceCream implements Dessert {

    public void play() {
        System.out.println("这是 IceCream");
    }
}

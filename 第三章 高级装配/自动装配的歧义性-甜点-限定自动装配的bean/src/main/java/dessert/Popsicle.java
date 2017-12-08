package main.java.dessert;

import main.java.inter.Cold;
import main.java.inter.Creamy;
import main.java.inter.Fruit;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
@Cold
@Fruit
public class Popsicle implements Dessert {
    public void play() {
        System.out.println("这是 水果冰棒");
    }
}

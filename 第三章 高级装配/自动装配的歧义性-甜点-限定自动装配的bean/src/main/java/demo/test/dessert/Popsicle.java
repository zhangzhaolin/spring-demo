package demo.test.dessert;


import demo.test.inter.Cold;
import demo.test.inter.Fruit;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 * 水果冰棒 类
 */

@Component
@Cold
@Fruit
public class Popsicle implements Dessert {

    @Override
    public void play() {
        System.out.println("这是 水果冰棒");
    }

}

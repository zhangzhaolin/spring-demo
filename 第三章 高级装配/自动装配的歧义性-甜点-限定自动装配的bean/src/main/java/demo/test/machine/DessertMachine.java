package demo.test.machine;

import demo.test.dessert.Dessert;
import demo.test.inter.Cold;
import demo.test.inter.Fruit;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class DessertMachine implements Machine {

    private Dessert dessert;

    @Autowired
    @Cold
    @Fruit
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }

    public void play(){
        dessert.play();
    }
}

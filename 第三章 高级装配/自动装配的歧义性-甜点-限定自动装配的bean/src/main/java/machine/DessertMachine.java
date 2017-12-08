package main.java.machine;

import main.java.dessert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class DessertMachine implements Machine {

    private Dessert dessert;

    @Autowired
    @Qualifier("iceCream")
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }

    public void play(){
        dessert.play();
    }
}

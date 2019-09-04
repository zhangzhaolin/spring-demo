package machine;

import dessert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class DessertMachine implements Machine {

    private Dessert dessert;

    @Autowired
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    @Override
    public void play() {
        dessert.play();
    }
}

package machine;

import dessert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class DessertMachine implements Machine {

    @Autowired
    private Dessert dessert;

    @Override
    public void play() {
        dessert.play();
    }
}

package main.java;

import main.java.config.ComponentConfig;
import main.java.dessert.Dessert;
import main.java.machine.DessertMachine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author shiwa
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComponentConfig.class)
public class MainTest {

    @Autowired
    private DessertMachine dessertMachine;

    @Test
    public void test(){
        dessertMachine.play();
    }

}

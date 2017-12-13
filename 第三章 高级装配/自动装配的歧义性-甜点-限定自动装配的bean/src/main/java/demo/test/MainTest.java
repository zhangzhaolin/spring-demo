package demo.test;

import demo.test.config.ComponentConfig;
import demo.test.machine.DessertMachine;
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

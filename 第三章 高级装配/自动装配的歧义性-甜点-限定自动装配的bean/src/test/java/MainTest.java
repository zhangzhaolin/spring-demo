import demo.test.config.ComponentConfig;
import demo.test.machine.DessertMachine;
import demo.test.machine.Machine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @author shiwa
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentConfig.class)
public class MainTest {

    @Autowired
    private Machine machine;

    @Test
    public void test() {
        machine.play();
    }

}

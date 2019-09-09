import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springinaction.knights.Knight;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(value = "classpath:/knight.xml")
class SpringContextTest {

    @Autowired
    private Knight knight;

    @Test
    void test() {
        knight.embarkOnQuest();
    }


}

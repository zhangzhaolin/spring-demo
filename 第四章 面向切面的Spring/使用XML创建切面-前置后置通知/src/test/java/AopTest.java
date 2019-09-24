import concert.Performance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath*:/application-context.xml")
// @ImportResource("classpath:/application-context.xml")
public class AopTest {

    @Autowired
    private Performance performance;

    @Test
    public void performTest() {
        performance.perform();
    }


}

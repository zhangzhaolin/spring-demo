import com.shiwa.spring.HelloService;
import com.shiwa.spring.config.RootConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = RootConfiguration.class)
@ActiveProfiles(value = "development")
public class SpringContextText {

    @Autowired
    private HelloService helloService;

    @Test
    public void profile() {
        Assertions.assertNotNull(helloService);
        System.out.println(helloService.sayHello());
    }

}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiwa
 */
@Configuration
@ConditionalOnMyProperties(name = "message")
public class ConditionClass {

    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }
}

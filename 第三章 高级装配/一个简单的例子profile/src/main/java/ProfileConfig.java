import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author shiwa
 */

@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devBean(){
        return new DemoBean("这是测试环境");
    }

    @Bean
    @Profile("prod")
    public DemoBean prodBean(){
        return new DemoBean("这是生产环境");
    }

}

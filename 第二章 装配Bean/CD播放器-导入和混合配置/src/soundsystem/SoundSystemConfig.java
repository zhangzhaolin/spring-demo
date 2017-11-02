package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author shiwa
 */

@Configuration
@Import({CDConfig.class,CDPlayerConfig.class})
@ImportResource("classpath:spring-config.xml")
public class SoundSystemConfig {

}

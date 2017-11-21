package soundsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shiwa
 */

@Configuration
@Import({CDConfig.class,CDPlayerConfig.class})
public class SoundSystemConfig {
}

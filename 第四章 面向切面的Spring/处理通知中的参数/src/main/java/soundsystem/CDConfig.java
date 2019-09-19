package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(exposeProxy = true)
@ImportResource(value = "classpath:/CDConfig.xml")
public class CDConfig {

}

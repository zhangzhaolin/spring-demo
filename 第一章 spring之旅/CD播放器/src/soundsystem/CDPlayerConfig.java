package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiwa
 * [@ComponentScan] 能够在spring中启用组件扫描
 * [@ComponentScan(basePackages = "soundsystem")] 类型不安全
 */

@Configuration
@ComponentScan(basePackageClasses = CdPlayerTest.class)
public class CDPlayerConfig {
    
}

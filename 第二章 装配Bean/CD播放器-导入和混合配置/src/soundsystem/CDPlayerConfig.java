package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shiwa
 * [@Configuration] 表示这个类是一个配置类
 * [@ComponentScan] 能够在spring中启用组件扫描
 * [@ComponentScan(basePackages = "soundsystem")] 类型不安全
 */

@Configuration
// @Import(CDConfig.class)
public class CDPlayerConfig {


    @Bean
    public CdPlayer cdPlayer(CompactDisc compactDisc){
        CdPlayer cdPlayer = new CdPlayer();
        cdPlayer.setCompactDisc(compactDisc);
        return cdPlayer;
    }

}

package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiwa
 * [@Configuration] 表示这个类是一个配置类
 * [@ComponentScan] 能够在spring中启用组件扫描
 * [@ComponentScan(basePackages = "soundsystem")] 类型不安全
 */

@Configuration
// @ComponentScan(basePackageClasses = CdPlayerTest.class)
public class CDPlayerConfig {

    /**
     * [@Bean] 告诉spring这个方法将会返回一个对象，该对象要注册为spring应用上下文
     * @return
     */
    @Bean(name = "lonelyHeartsClubBand")
    public CompactDisc sgtPeppers(){
        return new SgtPappers();
    }

    @Bean
    public CdPlayer cdPlayer(CompactDisc compactDisc){
        // return new CdPlayer(compactDisc);
        CdPlayer cdPlayer = new CdPlayer(compactDisc);
        cdPlayer.setCompactDisc(compactDisc);
        return cdPlayer;
    }


}

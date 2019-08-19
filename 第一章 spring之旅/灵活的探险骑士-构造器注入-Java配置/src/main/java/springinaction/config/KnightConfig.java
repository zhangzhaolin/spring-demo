package springinaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springinaction.knights.BraveKnight;
import springinaction.knights.Knight;
import springinaction.quest.Quest;
import springinaction.quest.SlayDragonQuest;

/**
 * @author zhang
 */
@Configuration
public class KnightConfig {

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

}

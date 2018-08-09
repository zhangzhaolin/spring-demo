package springinaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springinaction.knights.BraveKnight;
import springinaction.knights.Knight;
import springinaction.quest.Quest;
import springinaction.quest.RescueDamselQuest;
import springinaction.quest.SlayDragonQuest;

@Configuration
public class KnightConfig {

    @Bean
    public Quest rescueDamselQuest(){
        return new RescueDamselQuest(System.out);
    }

    @Bean
    public Quest slayDragonQuest(){
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Knight braveKnight(){
        return new BraveKnight(slayDragonQuest());
    }


}

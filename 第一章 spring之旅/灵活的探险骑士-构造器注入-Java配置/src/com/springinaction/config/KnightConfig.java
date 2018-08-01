package com.springinaction.config;

import com.springinaction.knights.BraveKnight;
import com.springinaction.knights.Knight;
import com.springinaction.quest.Quest;
import com.springinaction.quest.RescueDamselQuest;
import com.springinaction.quest.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

package springinaction.knights;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import springinaction.quest.Quest;

/**
 * @author shiwa
 */
public class BraveKnight implements Knight, ApplicationContextAware {

    private Quest quest;

    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware接口初始化");
    }
}

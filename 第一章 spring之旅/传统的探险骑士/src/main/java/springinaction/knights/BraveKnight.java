package main.java.springinaction.knights;

import main.java.springinaction.quest.RescueDamselQuest;

/**
 * @author shiwa
 *
 */
public class BraveKnight implements Knight {

    /**
     * 拯救少女任务
     */
    private RescueDamselQuest quest;

    public BraveKnight(){
        this.quest = new RescueDamselQuest();
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}

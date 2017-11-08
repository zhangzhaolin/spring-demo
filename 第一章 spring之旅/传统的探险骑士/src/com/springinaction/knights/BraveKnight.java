package com.springinaction.knights;

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
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}

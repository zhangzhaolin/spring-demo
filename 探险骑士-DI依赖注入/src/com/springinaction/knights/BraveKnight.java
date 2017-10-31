package com.springinaction.knights;

/**
 * @author shiwa
 * 勇敢骑士
 */
public class BraveKnight implements Knights {

    private Quest quest;

    /**
     *  构造器注入
     * @param quest
     */
    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}

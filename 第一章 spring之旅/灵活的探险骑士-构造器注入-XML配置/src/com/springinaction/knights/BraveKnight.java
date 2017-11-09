package com.springinaction.knights;

import com.springinaction.quest.Quest;

/**
 * @author shiwa
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}

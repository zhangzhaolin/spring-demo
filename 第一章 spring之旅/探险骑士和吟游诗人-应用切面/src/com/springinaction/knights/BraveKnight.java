package com.springinaction.knights;

import com.springinaction.minstrel.Minstrel;
import com.springinaction.quest.Quest;

/**
 * @author shiwa
 */
public class BraveKnight implements Knight {

    private Quest quest;

    // private Minstrel minstrel;

    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        // minstrel.singBeforeQuest();
        quest.embark();
        // minstrel.singAfterQuest();
    }
}

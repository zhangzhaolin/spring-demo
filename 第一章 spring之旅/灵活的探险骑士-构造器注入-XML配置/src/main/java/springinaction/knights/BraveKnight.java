package springinaction.knights;

import springinaction.quest.AbstractQuest;

/**
 * @author zhang
 */
public class BraveKnight implements Knight {

    private AbstractQuest quest;

    public BraveKnight(AbstractQuest quest){
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}

package springinaction.quest;

/**
 * @author shiwa
 */
public class RescueDamselQuest implements Quest {

    @Override
    public void embark() {
        System.out.println("勇士.请拯救你的少女!");
    }
}

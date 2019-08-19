package springinaction.quest;

import java.io.PrintStream;

/**
 * @author zhang
 */
public class SlayDragonQuest implements AbstractQuest {

    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println("勇士.请和恶龙争斗吧.");
    }

}

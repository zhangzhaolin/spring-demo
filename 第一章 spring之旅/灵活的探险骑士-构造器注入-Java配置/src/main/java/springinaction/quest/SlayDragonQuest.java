package springinaction.quest;

import java.io.PrintStream;

/**
 * @author shiwa
 */
public class SlayDragonQuest implements Quest {

    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println("勇士.请和恶龙争斗吧!");
    }
}

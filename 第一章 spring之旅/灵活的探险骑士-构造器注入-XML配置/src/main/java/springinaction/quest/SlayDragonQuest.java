package springinaction.quest;

import java.io.PrintStream;

public class SlayDragonQuest extends Quest {

    public SlayDragonQuest(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println("勇士.请和恶龙争斗吧.");
    }
}

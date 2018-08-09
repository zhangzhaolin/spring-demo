package springinaction.quest;

import springinaction.quest.Quest;

import java.io.PrintStream;

public class RescueDamselQuest extends Quest {

    public RescueDamselQuest(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println("勇士.请拯救您的少女.");
    }
}

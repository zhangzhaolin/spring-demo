package springinaction.quest;

import java.io.PrintStream;

/**
 * @author zhang
 */
public class RescueDamselQuest implements Quest {

    private PrintStream printStream;

    public RescueDamselQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println("勇士.请拯救您的少女.");
    }

}

package com.springinaction.quest;

import java.io.PrintStream;

/**
 * @author shiwa
 */
public class RescueDamselQuest implements Quest {

    private PrintStream printStream;

    public RescueDamselQuest(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println("勇士.请拯救你的少女!");
    }
}

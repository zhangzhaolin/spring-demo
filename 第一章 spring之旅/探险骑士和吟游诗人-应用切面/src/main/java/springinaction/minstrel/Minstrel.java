package springinaction.minstrel;

import java.io.PrintStream;

public class Minstrel {

    private PrintStream printStream;

    public Minstrel(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void singBeforeQuest(){
        printStream.println("探险前调用");
    }

    public void singAfterQuest(){
        printStream.println("探险后调用");
    }

}

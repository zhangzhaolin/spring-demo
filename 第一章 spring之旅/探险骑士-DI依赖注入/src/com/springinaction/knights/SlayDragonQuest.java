package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @author shiwa
 * 杀死一只怪龙的请求
 */
public class SlayDragonQuest implements Quest {

    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void embark(){
        printStream.println("杀死一只怪龙的请求!");
    }
}

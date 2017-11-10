package com.springinaction.minstrel;

import java.io.PrintStream;

/**
 * @author shiwa
 */
public class Minstrel {

    private PrintStream printStream;

    public Minstrel(PrintStream printStream){
        this.printStream = printStream;
    }

    /**
     *  探险之前调用
     */
    public void singBeforeQuest(){
        printStream.println("探险之前调用.");
    }

    /**
     *  探险之后调用
     */
    public void singAfterQuest(){
        printStream.println("探险之后调用.");
    }
}

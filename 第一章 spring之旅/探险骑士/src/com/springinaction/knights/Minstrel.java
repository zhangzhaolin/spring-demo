package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @author shiwa
 * 吟游诗人是中世纪的音乐记录器
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
        printStream.println("FA la la, the knight is so brave");
    }

    /**
     *  探险之后调用
     */
    public void singAfterQuest(){
        printStream.println("TEE hee hee, the brave knight did embark on a quest");
    }
}

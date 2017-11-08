package com.springinaction.quest;

/**
 * @author shiwa
 * 拯救少女请求
 */
public class RescueDamselQuest implements Quest {

    @Override
    public void embark() {
        System.out.println("勇士.请拯救你的少女!");
    }
}

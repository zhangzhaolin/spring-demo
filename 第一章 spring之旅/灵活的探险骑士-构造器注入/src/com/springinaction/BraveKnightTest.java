package com.springinaction;


import com.springinaction.knights.BraveKnight;
import com.springinaction.quest.Quest;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author shiwa
 */
public class BraveKnightTest{

    @Test
    public void knightShouldEmbarkQuest(){
        // 创建 mock Quest
        // 在测试对象BraveKnight时候 我们构造一个假的Quest对象来与BraveKnight交互
        Quest mockQuest = mock(Quest.class);
        // 注入 mock Quest
        BraveKnight braveKnight = new BraveKnight(mockQuest);
        braveKnight.embarkOnQuest();

        // 验证Quest中的embark()方法是否被调用 且 仅被调用1次
        verify(mockQuest,times(1)).embark();
    }
}

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import springinaction.knights.BraveKnight;
import springinaction.quest.Quest;


/**
 * @author shiwa
 */
class BraveKnightTest {

    @Test
    void knightShouldEmbarkQuest() {
        // 创建一个由mock方法实现的Quest接口
        Quest mockQuest = Mockito.mock(Quest.class);
        // 注入 mock Quest
        BraveKnight braveKnight = new BraveKnight(mockQuest);
        braveKnight.embarkOnQuest();
        // 验证embark()是否仅被调用了一次
        Mockito.verify(mockQuest, new Times(1)).embark();
    }
}

package springinaction.knights;

import org.springframework.beans.factory.annotation.Autowired;
import springinaction.quest.AbstractQuest;

/**
 * @author zhang
 */
public interface Knight {

    /**
     * 执行抽象请求
     */
    public void embarkOnQuest();

}

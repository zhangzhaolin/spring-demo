package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author shiwa
 * SpringJUnit4ClassRunner 在测试开始的时候自动创建spring上下文
 * [@ContextConfiguration] 告诉需要在CDPlayerConfig中加载配置
 */

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = CDPlayerConfig.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class CdPlayerTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc cd;
    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();
        assertEquals("Playing Sgt . Pepper's Lonely Hearts Club Band by The Beatles",log.getLog());
    }
}

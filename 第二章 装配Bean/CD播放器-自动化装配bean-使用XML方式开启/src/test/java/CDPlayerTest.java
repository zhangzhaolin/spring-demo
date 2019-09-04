import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.mediaplayer.MediaPlayer;

/**
 * @author shiwa
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class CDPlayerTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer mediaPlayer;

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void cdShouldNotBeNull() {
        Assertions.assertNotNull(compactDisc);
    }

    @Test
    public void play() {
        mediaPlayer.play();
        Assertions.assertNotNull("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles", log.getLog());
    }

}

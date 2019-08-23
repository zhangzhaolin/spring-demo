import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.config.CdPlayerConfig;
import soundsystem.mediaplayer.MediaPlayer;


/**
 * @author shiwa
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CdPlayerConfig.class)
public class CDPlayerTest {

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
        Assertions.assertEquals("Playing 寻宝游戏 by vae", mediaPlayer.play());
    }

}

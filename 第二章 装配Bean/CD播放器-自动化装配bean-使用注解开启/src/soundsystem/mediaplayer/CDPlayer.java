package soundsystem.mediaplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soundsystem.compactdisc.CompactDisc;

/**
 * @author shiwa
 */

@Component
public class CDPlayer implements MediaPlayer {

    @Autowired
    private CompactDisc compactDisc;

    @Override
    public void play() {
        compactDisc.play();
    }
}

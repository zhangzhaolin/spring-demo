package soundsystem.mediaplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soundsystem.compactdisc.CompactDisc;

/**
 * @author shiwa
 */

public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    // @Autowired
    public void setCompactDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}

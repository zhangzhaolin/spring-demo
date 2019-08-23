package soundsystem.mediaplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soundsystem.compactdisc.CompactDisc;

/**
 * @author shiwa
 */

@Component(value = "lonelyHeartsClub")
public class CdPlayer implements MediaPlayer {

    private final CompactDisc compactDisc;

    @Autowired
    public CdPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public String play() {
        return compactDisc.play();
    }
}

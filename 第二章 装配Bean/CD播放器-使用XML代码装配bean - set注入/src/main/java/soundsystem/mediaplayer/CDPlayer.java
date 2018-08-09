package soundsystem.mediaplayer;

import soundsystem.compactdisc.CompactDisc;

/**
 * @author shiwa
 */

public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    public void setCompactDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}

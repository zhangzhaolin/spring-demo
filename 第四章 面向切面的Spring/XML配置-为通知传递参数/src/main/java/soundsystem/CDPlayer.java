package soundsystem;

import org.springframework.stereotype.Component;

public class CDPlayer implements MediaPlayer {

    public void play(CompactDisc compactDisc) {
        compactDisc.play();
    }
}

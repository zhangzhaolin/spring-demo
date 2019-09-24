package soundsystem;

import org.springframework.stereotype.Component;

public class CDPlayer implements MediaPlayer {

    @Override
    public void play(CompactDisc compactDisc) {
        compactDisc.play();
    }
}

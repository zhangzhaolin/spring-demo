package soundsystem;

public class CdPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    public CdPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }

}

package soundsystem;

public class CDPlayer implements MediaPlayer{

    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    @Override
    public void play(){
        compactDisc.play();
    }

}

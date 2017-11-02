package soundsystem;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class CdPlayer implements MediaPlayer{

    private CompactDisc compactDisc;

    @Override
    public void play(){
        compactDisc.play();
    }

    public CompactDisc getCompactDisc() {
        return compactDisc;
    }

    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Autowired
    public void insertDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }
}

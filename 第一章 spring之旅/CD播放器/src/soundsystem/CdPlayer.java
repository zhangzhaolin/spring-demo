package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class CdPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Autowired(required = false)
    public CdPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Override
    public void play(){
        cd.play();
    }

    public CompactDisc getCd() {
        return cd;
    }

    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void insertDisc(CompactDisc cd){
        this.cd = cd;
    }
}

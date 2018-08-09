package soundsystem.compactdisc;

import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component(value = "sgtPeppers")
public class SgtPeppers implements CompactDisc {

    private String title = "寻宝游戏";

    private String artist = "vae";

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}

package soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component
public class SgtPappers implements CompactDisc {

    private String title = "Sgt . Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}

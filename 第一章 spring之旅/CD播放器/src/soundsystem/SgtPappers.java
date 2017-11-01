package soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author shiwa
 * [@Component] 这个注解表示该类会作为组建类，并告知spring要为这个类创建bean
 * bean的默认id是sgtPeppers
 * [@Component("lonelyHeartsClub")] 表示将这个bean标识为lonelyHeartsClub
 *
 */

@Component("lonelyHeartsClub")
public class SgtPappers implements CompactDisc {

    private String title = "Sgt . Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}

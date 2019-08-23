package soundsystem.compactdisc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author shiwa
 */

@Component(value = "sgtPeppers")
@PropertySource("classpath:/cd.properties")
public class SgtPeppers implements CompactDisc {

    @Value("${cd.title}")
    private String title;

    @Value("${cd.artist}")
    private String artist;

    @Override
    public String play() {
        return "Playing " + title + " by " + artist;
    }
}

package soundsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.compactdisc.SgtPeppers;
import soundsystem.mediaplayer.CDPlayer;

/**
 * @author shiwa
 */

@Configuration
@ComponentScan(basePackages = "soundsystem")
public class CDPlayerConfig {



}

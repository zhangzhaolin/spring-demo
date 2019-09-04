package soundsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import soundsystem.compactdisc.SgtPeppers;
import soundsystem.mediaplayer.CdPlayer;

/**
 * @author shiwa
 */

@Configuration
// @ComponentScan(basePackages = "soundsystem")
@ComponentScan(basePackageClasses = {SgtPeppers.class, CdPlayer.class})
public class CdPlayerConfig {


}

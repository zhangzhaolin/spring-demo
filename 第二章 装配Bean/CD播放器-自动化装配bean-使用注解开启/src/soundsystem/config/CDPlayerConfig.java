package soundsystem.config;

import org.springframework.context.annotation.ComponentScan;
import soundsystem.compactdisc.CompactDisc;
import soundsystem.mediaplayer.CDPlayer;

/**
 * @author shiwa
 */

// @ComponentScan(basePackages = {"soundsystem"})
@ComponentScan(basePackageClasses = {CompactDisc.class, CDPlayer.class})
public class CDPlayerConfig {

}

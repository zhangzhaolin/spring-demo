package soundsystem.compactdisc;

import soundsystem.compactdisc.CompactDisc;

import java.util.Set;

/**
 * @author shiwa
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    /**
     *  磁道
     */
    private Set<String> tracks;

    public BlankDisc(String title, String artist, Set<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
        for(String track:tracks){
            System.out.println("-Track : " +track);
        }
    }
}

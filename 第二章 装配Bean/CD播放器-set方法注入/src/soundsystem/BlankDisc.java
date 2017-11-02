package soundsystem;

import java.util.List;

/**
 * @author shiwa
 */
public class BlankDisc implements CompactDisc{

    private String title;
    private String artist;
    // 大多数的CD都会包含十多个磁道
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
        for (String track:tracks){
            System.out.println("-Track : " + track);
        }
    }
}

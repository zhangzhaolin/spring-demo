package soundsystem;

import java.util.List;

/**
 * @author shiwa
 */
public class BlankDisc implements CompactDisc{

    private String title;
    private String artist;
    /**
     *  大多数的CD都会包含十多个磁道
     */
    private List<String> tracks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
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

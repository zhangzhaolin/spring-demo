package soundsystem;


import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title,String artist,List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void play() {
        System.out.println("title :" + title + " artist :" + artist);
        for (int trackNumber = 0;trackNumber < tracks.size();trackNumber ++){
            playTrack(trackNumber);
        }
    }

    public void playTrack(int trackNumber) {
        System.out.println("track "+ trackNumber + " : " + tracks.get(trackNumber));
    }
}

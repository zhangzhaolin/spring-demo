package soundsystem;

public class SgtPeppers implements CompactDisc {

    private String title = "寻宝游戏";
    private String artist = "vae";

    @Override
    public void play() {
        System.out.println("title : " + title + " artist : " + artist);
    }
}

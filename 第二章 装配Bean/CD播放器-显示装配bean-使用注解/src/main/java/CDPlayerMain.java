import config.CdPlayerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import soundsystem.MediaPlayer;

public class CDPlayerMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CdPlayerConfig.class);
        MediaPlayer mediaPlayer = (MediaPlayer) context.getBean("mediaPlayer");
        mediaPlayer.play();
    }

}

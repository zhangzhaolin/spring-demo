
import org.springframework.context.support.ClassPathXmlApplicationContext;
import soundsystem.MediaPlayer;

public class CDPlayerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/cdconfig.xml");
        MediaPlayer mediaPlayer = (MediaPlayer) context.getBean("mediaPlayer");
        mediaPlayer.play();
    }

}

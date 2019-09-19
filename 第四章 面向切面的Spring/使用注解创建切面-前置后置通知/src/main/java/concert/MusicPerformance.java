package concert;

import org.springframework.stereotype.Component;

@Component
public class MusicPerformance implements Performance {

    @Override
    public void perform() {
        System.out.println("一场音乐会...");
        // int i = 2/0;
    }
}

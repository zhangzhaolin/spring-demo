package soundsystem;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 */
@Aspect
@Component
public class TrackCounter {

    public Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* soundsystem.BlankDisc.playTrack(int))  && args(trackNumber)")
    public void trackedPlay(int trackNumber) {
    }

    @AfterReturning(value = "trackedPlay(trackNumber)", argNames = "trackNumber")
    public void countTrack(int trackNumber) {
        trackCounts.compute(trackNumber, (k, v) -> v == null ? 1 : v + 1);
        System.out.println(trackCounts);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}

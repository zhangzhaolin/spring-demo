package soundsystem;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {

    public Map<Integer, Integer> trackCounts = new HashMap<>();

    public void countTrack(int trackNumber) {
        trackCounts.put(trackNumber, getPlayCount(trackNumber) + 1);
        System.out.println("--->track " + trackNumber + "数量增加了.");
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}

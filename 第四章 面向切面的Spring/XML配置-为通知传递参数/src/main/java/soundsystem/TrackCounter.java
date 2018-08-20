package soundsystem;

import jdk.nashorn.internal.ir.JoinPredecessor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {

    public Map<Integer,Integer> trackCounts = new HashMap<Integer, Integer>();

    // 通知playTrack方法
    public void playTrack(int trackNumber){}

    public void countTrack(int trackNumber){
        trackCounts.put(trackNumber,getPlayCount(trackNumber) + 1);
        System.out.println("--->track " + trackNumber + "数量增加了.");
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey(trackNumber)?
                trackCounts.get(trackNumber):0;
    }
}

package spittr.data;

import spittr.pojo.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> findSpittles(long max,int count);

}

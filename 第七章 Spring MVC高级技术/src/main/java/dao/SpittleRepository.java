package dao;

import org.springframework.dao.DataAccessException;
import pojo.Spittle;

import java.util.List;

public interface SpittleRepository {

    /**
     *
     * @param max Spittle中ID的最大个数
     * @param count 最多返回的Spittle个数
     * @return
     */
    List<Spittle> findSpittles(long max , int count);

    Spittle findSpittle(Long spittleId) throws DataAccessException;

}

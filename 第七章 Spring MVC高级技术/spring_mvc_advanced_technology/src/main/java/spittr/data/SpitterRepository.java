package spittr.data;

import org.springframework.dao.DataAccessException;
import spittr.pojo.Spitter;

/**
 * @author zhang
 */
public interface SpitterRepository {

    public Spitter save(Spitter spitter);

    public Spitter findOneByUserName(String username) throws DataAccessException;

    public long countSpitterByUserName(String username);
}

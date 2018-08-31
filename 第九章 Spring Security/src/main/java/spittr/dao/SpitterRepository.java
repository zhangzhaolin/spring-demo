package spittr.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spittr.pojo.Spitter;

import java.sql.SQLIntegrityConstraintViolationException;

public interface SpitterRepository extends UserDetailsService {

    public Spitter save(Spitter spitter) throws DataAccessException;

    public Spitter findOneByUserName(String username) throws DataAccessException;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}

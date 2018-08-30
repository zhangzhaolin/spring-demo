package spittr.dao;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import spittr.pojo.Spitter;

import java.sql.SQLIntegrityConstraintViolationException;

public interface SpitterRepository {

    public Spitter save(Spitter spitter) throws SQLIntegrityConstraintViolationException;

    public Spitter findOneByUserName(String username) throws IncorrectResultSizeDataAccessException;
}

package dao;

import errors.SpitterNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import pojo.Spitter;

import java.sql.SQLIntegrityConstraintViolationException;

public interface SpitterRepository {

    public Spitter save(Spitter spitter) throws SQLIntegrityConstraintViolationException;

    public Spitter findOneByUserName(String username) throws IncorrectResultSizeDataAccessException;
}

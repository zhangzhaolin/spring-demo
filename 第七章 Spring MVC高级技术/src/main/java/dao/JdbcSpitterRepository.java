package dao;

import errors.SpitterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pojo.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public Spitter save(Spitter spitter) throws SQLIntegrityConstraintViolationException {
        jdbcOperations.update(
                "insert into Spitter (username, password, first_name, last_name, email , imglogo)" +
                        " values (?, ?, ?, ?, ? , ?)",
                spitter.getUserName(), spitter.getPassWord(),
                spitter.getFirstName(),spitter.getLastName(),
                spitter.getEmail(),spitter.getImgLogo());
        return spitter;
    }

    @Override
    public Spitter findOneByUserName(String username) throws IncorrectResultSizeDataAccessException {
        return jdbcOperations.queryForObject("SELECT * FROM spitter where username = ?",
                new SpitterRowMapper(),username);
    }

    private class SpitterRowMapper implements RowMapper<Spitter>{

        @Override
        public Spitter mapRow(ResultSet resultSet , int i) throws SQLException {
            return new Spitter(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("userName"),
                    resultSet.getString("passWord") ,
                    resultSet.getString("email"),
                    resultSet.getString("imgLogo"));
        }
    }

}

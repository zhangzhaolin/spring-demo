package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.pojo.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public Spitter save(Spitter spitter) {
        if (countSpitterByUserName(spitter.getUserName()) != 0) {
            throw new DataRetrievalFailureException("用户名已存在");
        }
        jdbcOperations.update(
                "insert into Spitter (username, password, first_name, last_name, email)" +
                        " values (?, ?, ?, ?, ?)",
                spitter.getUserName(),
                spitter.getPassWord(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter;
    }

    @Override
    public Spitter findOneByUserName(String username) {
        return jdbcOperations.queryForObject("SELECT * FROM spitter where username = ?",
                new SpitterRowMap(), username);
    }

    @Override
    public long countSpitterByUserName(String username) {
        return jdbcOperations.queryForObject("SELECT COUNT(*) FROM spitter WHERE username = ?", Long.class, username);
    }

    private static class SpitterRowMap implements RowMapper<Spitter> {

        @Override
        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spitter(
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("userName"),
                    resultSet.getString("passWord"),
                    resultSet.getString("email"));
        }

    }
}

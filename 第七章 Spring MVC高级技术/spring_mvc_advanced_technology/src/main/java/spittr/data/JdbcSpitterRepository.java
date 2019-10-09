package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import spittr.pojo.Spitter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public Spitter save(Spitter spitter) {
        String sql = "insert into Spitter (username, password, first_name, last_name, email,img_url) values (?, ?, ?, ?, ?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, spitter.getUserName());
            ps.setString(2, spitter.getPassWord());
            ps.setString(3, spitter.getFirstName());
            ps.setString(4, spitter.getLastName());
            ps.setString(5, spitter.getEmail());
            ps.setString(6, spitter.getImageUrl());
            return ps;
        }, keyHolder);
        spitter.setId(keyHolder.getKey().longValue());
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
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("userName"),
                    resultSet.getString("passWord"),
                    resultSet.getString("email"),
                    resultSet.getString("img_url"));
        }

    }
}

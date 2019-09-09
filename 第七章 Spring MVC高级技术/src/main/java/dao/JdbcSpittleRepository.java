package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pojo.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Spittle> findSpittles(long max , int count) {
        return jdbcOperations.query("SELECT * FROM spittle WHERE ID < ? ORDER BY created_at desc LIMIT ?" ,
                new SpittleRowMapper() , max , count);
    }

    public Spittle findSpittle(Long spittleId) throws DataAccessException {
        return jdbcOperations.queryForObject("SELECT * FROM spittle WHERE id = ?",
                new SpittleRowMapper(),spittleId);
    }

    private class SpittleRowMapper implements RowMapper<Spittle>{
        public Spittle mapRow(ResultSet resultSet , int i) throws SQLException {
            return new Spittle(resultSet.getLong("id"),
                    resultSet.getString("message"),
                    resultSet.getTimestamp("created_at"),
                    resultSet.getDouble("latitude"),
                    resultSet.getDouble("longitude")
            );
        }
    }

}

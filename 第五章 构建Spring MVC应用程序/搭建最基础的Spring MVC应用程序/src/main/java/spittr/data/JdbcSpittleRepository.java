package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.pojo.Spittle;

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
               new SpittleRowMap() , max , count);
    }

    private class SpittleRowMap implements RowMapper<Spittle>{
        @Override
        public Spittle mapRow(ResultSet rs , int rowNum) throws SQLException {
            return new Spittle(
                    rs.getLong("id"),
                    rs.getString("message"),
                    rs.getDate("created_at"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude")
            );
        }
    }
}

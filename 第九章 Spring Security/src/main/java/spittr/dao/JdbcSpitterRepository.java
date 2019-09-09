package spittr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import spittr.pojo.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
        public Spitter save(Spitter spitter) throws DataAccessException {
        jdbcOperations.update(
                "insert into Spitter (username, password, first_name, last_name, email , imglogo)" +
                        " values (?, ?, ?, ?, ? , ?)",
                spitter.getUserName(), spitter.getPassWord(),
                spitter.getFirstName(),spitter.getLastName(),
                spitter.getEmail(),spitter.getImgLogo());
        return spitter;
    }

    @Override
    public Spitter findOneByUserName(String username) throws DataAccessException {
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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            Spitter spitter = findOneByUserName(s);
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(spitter.getUserName(),spitter.getPassWord(),authorities);
        }catch (Exception e){
            throw new UsernameNotFoundException("用户名为 : " + s + "没有找到.");
        }
    }
}

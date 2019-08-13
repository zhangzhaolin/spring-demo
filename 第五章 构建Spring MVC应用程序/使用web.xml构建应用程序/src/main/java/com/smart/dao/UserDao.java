package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String FIND_USER_BY_USERNAME_SQL = "SELECT * FROM t_user WHERE user_name = ?";
    private final static String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user SET credits = ?,last_visit = ?,last_ip = ? WHERE user_id = ?";
    private final static String GET_MATCH_COUNT = "SELECT COUNT(*) FROM t_user WHERE user_name = ? AND password = ?";

    public User findUserByUserName(String userName){
        return jdbcTemplate.queryForObject(FIND_USER_BY_USERNAME_SQL,new UserDaoMapper(),userName);
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,user.getCredits(),user.getLastVisit(),user.getLastIp(),user.getUserId());
    }

    public Integer getMatchCount(String username, String password) {
        return jdbcTemplate.queryForObject(GET_MATCH_COUNT,Integer.class,username,password);
    }

    private class UserDaoMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getLong("user_id"),resultSet.getString("user_name"),
                    resultSet.getLong("credits"),resultSet.getString("password"),
                    resultSet.getTimestamp("last_visit"),resultSet.getString("last_ip"));
        }
    }

}

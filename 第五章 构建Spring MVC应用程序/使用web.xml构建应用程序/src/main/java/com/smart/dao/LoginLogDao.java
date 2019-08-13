package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoginLogDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_LOGIN_LOG = "INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES (?,?,?)";

    public void insertLoginLog(LoginLog log){
        jdbcTemplate.update(INSERT_LOGIN_LOG,log.getUserId(),log.getIp(),log.getLoginDateTime());
    }
}

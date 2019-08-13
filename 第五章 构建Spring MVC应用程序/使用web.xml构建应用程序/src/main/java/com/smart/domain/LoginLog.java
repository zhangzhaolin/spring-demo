package com.smart.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class LoginLog implements Serializable {

    private Long loginLongId;
    private Long userId;
    private String ip;
    private Timestamp loginDateTime;

    public LoginLog(){

    }

    public LoginLog(Long userId, String ip, Timestamp loginDateTime) {
        this.userId = userId;
        this.ip = ip;
        this.loginDateTime = loginDateTime;
    }

    public Long getLoginLongId() {
        return loginLongId;
    }

    public void setLoginLongId(Long loginLongId) {
        this.loginLongId = loginLongId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Timestamp loginDateTime) {
        this.loginDateTime = loginDateTime;
    }
}
